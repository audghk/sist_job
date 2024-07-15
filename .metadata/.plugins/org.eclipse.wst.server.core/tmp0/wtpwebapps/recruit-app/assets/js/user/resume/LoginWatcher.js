var LoginWatcher = (function () {

    var keepShowLayerSeconds = 60 * 10;       // 로그인 연장 레이어 팝업 노출 시간
    var expireSeconds        = 60 * 105;      // 유효 시간
    var displaySeconds       = 60 * 10;       // 연장 레이어 팝업 표시되는 시간
    var loginTimeChecktimer = null;
    var objCountDown = null;
    var currentLayer = null;
    var _options = {
        SaveFunction: null,
        LoginDescription: null
    };

    var isShowLayer = false;

    var EXPIRE_DATETIME;                    // 만료 시간 

    var ajaxExpireTime;

    var $elements = {
        layerKeepLogin: $(".popup-keep-login-session"),
        btnKeepLogin: $(".button-keep-login-session"),
        btnLayerKeepClose: $(".popup-keep-login-session").find(".button-close-popup"),
        layerRelogin: $(".popup-relogin"),
        btnLayerReloginClose: $(".popup-relogin").find(".button-close-popup"),
        countDown: $(".countdown"),
        ifrmRelogin: $("#ifrmRelogin")
    }

    // 모니터링 용도
    var timerStartDate = "";
    var timerEndDate = "";
    var isDebug = false;

    function _getDateObject(date)
    {
        var result = new Date();


        if (date instanceof Date) {
            result = date;
        } else {
            var _date = date.indexOf("-") > -1 ? date.replace(/[.-]/gi, "/") : date;
            result = new Date(_date);
        }

        return result;
    } 

    function _dateDiffSeconds(date1, date2) {
        var t1 = _getDateObject(date1);
        var t2 = _getDateObject(date2);
        var diff = t2.getTime() - t1.getTime();
        
        return Math.ceil(diff / 1000);
    }

    function _dateAddSeconds(date, seconds) {
        var _date = _getDateObject(date);
        return new Date(_date.getTime() + (1000 * seconds));
    }

    function _promiseKeepLogin() {
        var url = "/Login/KeepTime";
        var data = "";
        if (timerStartDate && timerEndDate) {
            data += "timerStartDate=" + timerStartDate;
            data += "&timerEndDate=" + timerEndDate;
        }

        var promise = $.ajax({
            method:"post",
            url: url,
            data: data,
            cache: false
        });

        return promise;
    }

    function _promiseExpireSeconds() {
        var url = "/Login/ExpireTime";
        var promise = $.ajax({
            url: url,
            cache: false,
            async: false
        })

        return promise;
    }

    function _setExpireSeconds() {

        var promise = _promiseExpireSeconds().done(function (res) {
            if (res && res.CResult == 1) {
                ajaxExpireTime = res;


                var diffSeconds = _dateDiffSeconds(new Date(), res.CurrentTime);
                if (isNaN(diffSeconds)) {
                    console.log("_setExpireSeconds diffSeconds Error");
                }

                // 서버와 클라이언트가 시간 차이가 나면 만료 시간 조정 
                if (diffSeconds > 0) { // 서버가 큰경우
                    EXPIRE_DATETIME = _dateAddSeconds(res.ExpireTime, -diffSeconds);
                }
                else if (diffSeconds < 0) { // 클라이언트가 큰경우
                    EXPIRE_DATETIME = _dateAddSeconds(res.ExpireTime, Math.abs(diffSeconds));
                }
                else
                {
                    EXPIRE_DATETIME = _getDateObject(res.ExpireTime);
                }

                expireSeconds = _dateDiffSeconds(new Date(), EXPIRE_DATETIME);
            } else {
                expireSeconds = 0;
            }
        });

        return promise;
    }

    function _isLogin() {
        var isLogin = false;

        _promiseExpireSeconds().done(function (res) {
            if (res && res.CResult == 1) {
                isLogin = true;
            }
        });

        return isLogin;
    }

    function _logOut() {

        if (!_isLogin()) {
            _allStop();
            _showLoginLayer();
            return;
        }

        if (typeof _options.SaveFunction == 'function') {
            _options.SaveFunction();
        }

        //간헐적으로 로그인 레이어가 뜨면서 
        //쿠키가 삭제되어 Savefunction() 오작동이 발생하여 
        //일단 타이머로 처리함
        setTimeout(_showLoginLayer,1000);
    }

    function _startTimer() {

        if (!loginTimeChecktimer) {

            _initTimerDatetime();
            timerStartDate = _getDate("yyyyMMdd_HHmmss");

            _setExpireSeconds().done(function () {

                loginTimeChecktimer = setInterval(_startLoginWatch, 1000);

            });
        }
    }

    function _stopTimer() {
        timerEndDate = _getDate("yyyyMMdd_HHmmss");
        clearInterval(loginTimeChecktimer);
        loginTimeChecktimer = null;
    }

    function _startCountDown() {
        var _displayMinute = parseInt(displaySeconds / 60, 10);
        var _displaySeconds = displaySeconds % 60;
        var countdown = $elements.countDown[0];

        if (!objCountDown) {
            objCountDown = new Countdown(countdown, {
                number: {
                    minutes: _displayMinute,
                    seconds: _displaySeconds
                },
                end: function () {
                    _stopCountDown()
                    _logOut();

                }
            });
        }
    }

    function _stopCountDown() {
        if (objCountDown) {
            objCountDown.stop();
            objCountDown = null;
        }
    }

    function _startLoginWatch() {

        if (isDebug) {
            console.log("_startLoginWatch call : currentDate :", _getDate("yyyyMMdd_HHmmss"), " expireSeconds :", expireSeconds, "EXPIRE_DATE : ", _dateFormat(EXPIRE_DATETIME,"yyyyMMdd_HHmmss"));
        }

        if (expireSeconds > 0) {
            if (expireSeconds <= keepShowLayerSeconds) {

                _stopTimer();

                if (expireSeconds < displaySeconds) {
                    displaySeconds = expireSeconds;
                }

                _showLoginKeepLayer();

            } else {
                expireSeconds = _dateDiffSeconds(new Date(), EXPIRE_DATETIME);
            };
        } else {
            _stopTimer();
        }
    }

    function _keepLogin() {
        _promiseKeepLogin().done(function (result) {

            if (result == "1") {
                _hideCurrentLayer();
                _startTimer();
            } else
            {
                _showLoginLayer();
            }

        });
    }

    function _showLayer($target) {
        isShowLayer = true;
        $target.removeClass("hidden");
        $target.attr("aria-hidden", "false");
        currentLayer = $target;
    }

    function _hideLayer($target) {
        isShowLayer = false;
        $target.addClass("hidden").attr("aria-hidden", "true");
        currentLayer = null;
    }

    function _showLoginKeepLayer() {

        if (!_isLogin()) {
            _allStop();
            return;
        }

        _hideCurrentLayer();
        _showLayer($elements.layerKeepLogin);
        _startCountDown();

    }

    function _showLoginLayer() {

        var ifrmUrl = "/Login/M_Login_Resume";

        ifrmUrl += "?re_url=" + encodeURIComponent("/Login/M_Login_Resume_Callback");

        if (location.protocol == "https:") {
            ifrmUrl += "&isSSL=1";
        }

        if (_options.LoginDescription) {
            ifrmUrl += "&description=" + encodeURIComponent(_options.LoginDescription);
        }

        if (document.domain.indexOf("www") > -1) {
            ifrmUrl = "https://" + document.domain + ifrmUrl;
        }

        var targetDate = _getParameter("targetdate");
        if (targetDate) {
            ifrmUrl += "&targetdate=" + targetDate;
        }

        $elements.ifrmRelogin.attr("src", ifrmUrl);

        _hideCurrentLayer();
        _showLayer($elements.layerRelogin);
    }

    function _getParameter(param) {
        var result = "";
        var url = unescape(location.href);
        var paramArr = (url.substring(url.indexOf("?") + 1, url.length)).split("&");

        for (var i = 0; i < paramArr.length; i++) {
            var temp = paramArr[i].split("=");
            if (temp[0].toUpperCase() == param.toUpperCase()) {
                result = paramArr[i].split("=")[1];
                break;
            }
        }
        return result;
    }

    function _hideCurrentLayer() {
        if (currentLayer) {
            _hideLayer(currentLayer);
        }
    }

    function _onClickLayerClose() {
        _hideCurrentLayer();
    }

    function _onClickKeepLogin() {

        _stopCountDown();
        _keepLogin();
    }

    function _bindEvent() {
        $elements.btnKeepLogin.click(_onClickKeepLogin);
        $elements.btnLayerKeepClose.click(_onClickLayerClose);
        $elements.btnLayerReloginClose.click(_onClickLayerClose);
    }

    function _allStop() {
        _hideCurrentLayer();
        _stopTimer();
        _stopCountDown();
    }

    function _pad(number, length) {
        var str = number.toString();

        while (str.length < length) {
            str = '0' + str;
        }
        return str;
    }

    function _getDate(format)
    {
        var date = new Date();
        
        return _dateFormat(date, format);
    }

    function _dateFormat(date, format) {

        if (format) {
            var weekName = ["일요일", "월요일", "화요일", "수요일", "목요일", "금요일", "토요일"];
            var d = date;
            var f = format;

            result = f.replace(/(yyyy|yy|MM|dd|E|hh|mm|ss|a\/p)/gi, function ($1) {
                switch ($1) {
                    case "yyyy": return d.getFullYear();
                    case "yy": return _pad(d.getFullYear() % 1000, 2);
                    case "MM": return _pad(d.getMonth() + 1, 2);
                    case "dd": return _pad(d.getDate(), 2);
                    case "E": return weekName[d.getDay()];
                    case "HH": return _pad(d.getHours(), 2);
                    case "hh": return ((h = d.getHours() % 12) ? h : 12, 2);
                    case "mm": return _pad(d.getMinutes(), 2);
                    case "ss": return _pad(d.getSeconds(), 2);
                    case "a/p": return d.getHours() < 12 ? "오전" : "오후";
                    default: $1;
                }
            });
        }

        return result;
    }

    function _pad(number, length) {
        var str = number.toString();

        while (str.length < length) {
            str = '0' + str;
        }
        return str;
    }

    function _initTimerDatetime()
    {
        timerStartDate = "";
        timerEndDate = "";
    }

    function _status() {
        console.log("loginTimeChecktimer : ", loginTimeChecktimer);
        console.log("objCountDown : ", objCountDown);
        console.log("currentLayer : ", currentLayer);
        console.log("IsShowLayer : ", isShowLayer);
        console.log("_options :", _options);
        console.log("expireSeconds  :", expireSeconds);
        console.log("keepShowLayerSeconds  :", keepShowLayerSeconds);
        console.log("timerStartDate  :", timerStartDate);
        console.log("timerEndDate  :", timerEndDate);
        console.log("EXPIRE_DATETIME  :", _dateFormat(EXPIRE_DATETIME, "yyyyMMdd_HHmmss"));
        console.log("ajaxExpireTime :" , ajaxExpireTime);
    }

    function Init(options) {
        _.extend(_options, options);
        _startTimer();
        _bindEvent();
    }

    function IsShowLayer() {
        return isShowLayer;
    }

    function Restart() {

        _hideCurrentLayer();
        _startTimer();
    }

    function ShowLoginLayer() {
        _stopTimer();
        _showLoginLayer();
    }

    return {

        Init: Init,
        IsShowLayer: IsShowLayer,
        Restart: Restart,
        Status: _status,
        
        SetIsDebug : function(bool){
            isDebug = bool;
        },
        SetTime: function (ex, ds) {
            //expireSeconds = ex;
            EXPIRE_DATETIME = _dateAddSeconds(new Date(), ex);
            displaySeconds = ds;
        },
        ShowLoginLayer: ShowLoginLayer

    };

})();