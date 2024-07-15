window.Countdown = (function (Countdown) {

    Countdown = function (container, options) {
        if (!container) {
            return;
        }
        this.container = container;
        this.options = options;
        this.daysElement = this.container.querySelector('.days') || '';
        this.hoursElement = this.container.querySelector('.hours') || '';
        this.minutesElement = this.container.querySelector('.minutes') || '';
        this.secondsElement = this.container.querySelector('.seconds') || '';
        this.number = this.options.number;
        this.init();
    }

    Countdown.prototype = {
        init: function () {
            var self = this;
            this.days = this.options.number.days || 0;
            this.hours = this.options.number.hours || 0;
            this.minutes = this.options.number.minutes || 0;
            this.seconds = this.options.number.seconds || 0;
            this.date = Date.now();
            this.timer;
            this.callbackEnd = this.options.end || function () { };
            this.options.type = this.options.number.days ? 'days' : this.options.number.hours ? 'hours' : this.options.number.minutes ? 'minutes' : 'seconds';
            console.log(this.options.type);
            switch (this.options.type) {
                case 'days':
                    this.setTimerDays();
                    break;
                case 'hours':
                    this.setTimerHours();
                    break;
                case 'minutes':
                    this.setTimerMinutes();
                    break;
                case 'seconds':
                    this.setTimerSeconds();
                    break;
            }
        },
        getDays : function() {
            return (this.days * 60 * 60 * 24) * 1000;
        },
        getHours : function() {
            return (this.hours * 60 * 60) * 1000;
        },
        getMinutes : function() {
            return (this.minutes * 60) * 1000;
        },
        getSeconds : function() {
            return this.seconds * 1000;
        },
        setTimerDays : function() {
            var self = this;
            this.daysElement.textContent = this.days;
            this.hoursElement.textContent = this.hours;
            this.minutesElement.textContent = this.minutes;
            this.secondsElement.textContent = this.seconds;
            this.then = this.date + this.getDays() + this.getHours() + this.getMinutes() + this.getSeconds();
            this.setTimer(function (seconds) {
                self.setTimeLeftDays(seconds);
                self.setTimeLeftHours(seconds);
                self.setTimeLeftMinutes(seconds);
                self.setTimeLeftSeconds(seconds);
            });
        },
        setTimerHours: function() {
            var self = this;
            this.hoursElement.textContent = this.hours;
            this.minutesElement.textContent = this.minutes;
            this.secondsElement.textContent = this.seconds;
            this.then = this.date + this.getHours() + this.getMinutes() + this.getSeconds();
            this.setTimer(function (seconds) {
                self.setTimeLeftHours(seconds);
                self.setTimeLeftMinutes(seconds);
                self.setTimeLeftSeconds(seconds);
            });
        },
        setTimerMinutes: function() {
            var self = this;
            this.minutesElement.textContent = this.minutes;
            this.secondsElement.textContent = this.seconds;
            this.then = this.date + this.getMinutes() + this.getSeconds();
            console.log(this.then);
            this.setTimer(function(seconds) {
                self.setTimeLeftMinutes(seconds);
                self.setTimeLeftSeconds(seconds);
            });
        },
        setTimerSeconds: function() {
            var self = this;
            this.secondsElement.textContent = this.seconds;
            this.then = this.date + this.getSeconds();
            this.setTimer(function(seconds) {
                self.setTimeLeftSeconds(seconds);
            });
        },
        setTimer : function(callback) {
            var self = this;
            this.timer = setTimeout(function () {
                self.calculator(function (seconds) {
                    if (callback && typeof callback == "function") {
                        callback(seconds);
                    }
                    self.setTimer(callback);
                });
            }, 1000);
        },
        calculator : function(callback) {
            var secondsLeft = Math.round((this.then - Date.now()) / 1000);
            if (secondsLeft < 0) {
                clearTimeout(this.timer);
                if (this.callbackEnd && typeof this.callbackEnd == "function") {
                    this.callbackEnd();
                }
            } else {
                if (callback && typeof callback == "function") {
                    callback(secondsLeft);
                }
            }
        },
        setTimeLeftDays : function (seconds) {
            this.daysElement.textContent = this.setValue(Math.floor(seconds / 86400));
        },
        setTimeLeftHours : function (seconds) {
            this.hoursElement.textContent = this.setValue(Math.floor((seconds % 86400) / 3600));
        },
        setTimeLeftMinutes : function(seconds) {
            this.minutesElement.textContent = this.setValue(Math.floor((seconds % 86400) % 3600 / 60));
        },
        setTimeLeftSeconds : function(seconds) {
            this.secondsElement.textContent = this.setValue(seconds % 60);
        },
        setValue : function(value) {
            return value < 10 ? '0' + value : value;;
        },
        stop : function() {
            clearTimeout(this.timer);
        },
        reset : function(options) {
            this.options = options;
            this.init();
        }
    }

    return Countdown;

})(window.Countdown || {});

// ;(function() {

//     var resume = document.querySelector('.resume-write');
//     if(!resume) {
//         return false;
//     }
//     var form = resume.querySelector('#frm1');
//     if(form.firstChild.nodeName == '#text') {
//         form.removeChild(form.firstChild);
//     }

// }());