
$(function () {
    var LanguageModel = Backbone.Model.extend({});
    var LanguageCollection = Backbone.Collection.extend({
      model: LanguageModel,
    });
    var languageCollection = new LanguageCollection(
      JSON.parse("[]")
    );

    var LanguageExamCollection = Backbone.Collection.extend({
      byLangCode: function (langCode) {
        return this.filter(function (m) {
          return m.get("Lang_Code") == langCode;
        });
      },
    });

    var languageExamCollection = new LanguageExamCollection(
      JSON.parse(
        '[{"Lang_Code":16,"Exam_Code":1,"Exam_Name":"TOEIC"},{"Lang_Code":16,"Exam_Code":28,"Exam_Name":"TOEIC(Speaking)"},{"Lang_Code":16,"Exam_Code":77,"Exam_Name":"TOEIC(Writing)"},{"Lang_Code":16,"Exam_Code":29,"Exam_Name":"TOEIC Speaking and Writing Tests"},{"Lang_Code":16,"Exam_Code":2,"Exam_Name":"TOEFL(PBT)"},{"Lang_Code":16,"Exam_Code":21,"Exam_Name":"TOEFL(CBT)"},{"Lang_Code":16,"Exam_Code":24,"Exam_Name":"TOEFL(iBT)"},{"Lang_Code":16,"Exam_Code":3,"Exam_Name":"TEPS"},{"Lang_Code":16,"Exam_Code":14,"Exam_Name":"IELTS"},{"Lang_Code":16,"Exam_Code":15,"Exam_Name":"G-TELP(GLT)"},{"Lang_Code":16,"Exam_Code":16,"Exam_Name":"G-TELP(GST)"},{"Lang_Code":16,"Exam_Code":75,"Exam_Name":"G-TELP(GWT)"},{"Lang_Code":16,"Exam_Code":76,"Exam_Name":"G-TELP(GBST)"},{"Lang_Code":16,"Exam_Code":17,"Exam_Name":"SLEP"},{"Lang_Code":16,"Exam_Code":18,"Exam_Name":"GRE"},{"Lang_Code":16,"Exam_Code":19,"Exam_Name":"GMAT"},{"Lang_Code":16,"Exam_Code":23,"Exam_Name":"PELT"},{"Lang_Code":20,"Exam_Code":4,"Exam_Name":"JPT"},{"Lang_Code":16,"Exam_Code":30,"Exam_Name":"OPIc"},{"Lang_Code":20,"Exam_Code":13,"Exam_Name":"JLPT"},{"Lang_Code":16,"Exam_Code":79,"Exam_Name":"OPIc Listening\\u0026Reading"},{"Lang_Code":20,"Exam_Code":34,"Exam_Name":"新JLPT"},{"Lang_Code":16,"Exam_Code":63,"Exam_Name":"OPIc Writing"},{"Lang_Code":20,"Exam_Code":20,"Exam_Name":"JTRA"},{"Lang_Code":16,"Exam_Code":80,"Exam_Name":"OPI"},{"Lang_Code":20,"Exam_Code":27,"Exam_Name":"NPT"},{"Lang_Code":16,"Exam_Code":64,"Exam_Name":"FLEX 영어"},{"Lang_Code":21,"Exam_Code":8,"Exam_Name":"HSK"},{"Lang_Code":21,"Exam_Code":32,"Exam_Name":"新HSK"},{"Lang_Code":21,"Exam_Code":33,"Exam_Name":"HSK회화"},{"Lang_Code":4,"Exam_Code":11,"Exam_Name":"ZDAF"},{"Lang_Code":4,"Exam_Code":12,"Exam_Name":"ZMP"},{"Lang_Code":4,"Exam_Code":7,"Exam_Name":"GDS"},{"Lang_Code":4,"Exam_Code":9,"Exam_Name":"KDS"},{"Lang_Code":27,"Exam_Code":6,"Exam_Name":"DELF"},{"Lang_Code":27,"Exam_Code":5,"Exam_Name":"DALF"},{"Lang_Code":5,"Exam_Code":25,"Exam_Name":"TORFL"},{"Lang_Code":13,"Exam_Code":26,"Exam_Name":"DELE"},{"Lang_Code":0,"Exam_Code":99,"Exam_Name":"기타"},{"Lang_Code":21,"Exam_Code":35,"Exam_Name":"新HSK회화"},{"Lang_Code":21,"Exam_Code":36,"Exam_Name":"TSC"},{"Lang_Code":20,"Exam_Code":37,"Exam_Name":"SJPT"},{"Lang_Code":21,"Exam_Code":38,"Exam_Name":"OPIc"},{"Lang_Code":13,"Exam_Code":39,"Exam_Name":"OPIc"},{"Lang_Code":5,"Exam_Code":40,"Exam_Name":"OPIc"},{"Lang_Code":21,"Exam_Code":42,"Exam_Name":"BCT"},{"Lang_Code":21,"Exam_Code":43,"Exam_Name":"CPT"},{"Lang_Code":21,"Exam_Code":78,"Exam_Name":"HSKK"},{"Lang_Code":21,"Exam_Code":81,"Exam_Name":"OPI"},{"Lang_Code":27,"Exam_Code":82,"Exam_Name":"OPI"},{"Lang_Code":4,"Exam_Code":83,"Exam_Name":"OPI"},{"Lang_Code":5,"Exam_Code":84,"Exam_Name":"OPI"},{"Lang_Code":32,"Exam_Code":85,"Exam_Name":"OPI"},{"Lang_Code":32,"Exam_Code":86,"Exam_Name":"OPIc"},{"Lang_Code":32,"Exam_Code":44,"Exam_Name":"국어능력인증시험"},{"Lang_Code":32,"Exam_Code":45,"Exam_Name":"한국어 교원자격증"},{"Lang_Code":32,"Exam_Code":46,"Exam_Name":"KBS 한국어능력시험"},{"Lang_Code":32,"Exam_Code":47,"Exam_Name":"TOPIK"},{"Lang_Code":20,"Exam_Code":48,"Exam_Name":"OPIc"},{"Lang_Code":21,"Exam_Code":49,"Exam_Name":"新BCT(A)"},{"Lang_Code":21,"Exam_Code":50,"Exam_Name":"新BCT(B)"},{"Lang_Code":21,"Exam_Code":51,"Exam_Name":"新BCT(Speaking)"},{"Lang_Code":4,"Exam_Code":52,"Exam_Name":"DSH"},{"Lang_Code":4,"Exam_Code":53,"Exam_Name":"FLEX 독일어"},{"Lang_Code":4,"Exam_Code":54,"Exam_Name":"PWD"},{"Lang_Code":4,"Exam_Code":55,"Exam_Name":"SD1"},{"Lang_Code":4,"Exam_Code":56,"Exam_Name":"SD2 "},{"Lang_Code":4,"Exam_Code":57,"Exam_Name":"SNULT 독일어"},{"Lang_Code":4,"Exam_Code":58,"Exam_Name":"TCT 번역능력인정시험 독일어"},{"Lang_Code":4,"Exam_Code":59,"Exam_Name":"TestDaF"},{"Lang_Code":4,"Exam_Code":60,"Exam_Name":"ZD"},{"Lang_Code":4,"Exam_Code":61,"Exam_Name":"ZOP"},{"Lang_Code":4,"Exam_Code":62,"Exam_Name":"관광통역안내사 독일어"},{"Lang_Code":5,"Exam_Code":65,"Exam_Name":"FLEX 러시아어"},{"Lang_Code":13,"Exam_Code":66,"Exam_Name":"FLEX 스페인어"},{"Lang_Code":20,"Exam_Code":67,"Exam_Name":"FLEX 일본어"},{"Lang_Code":21,"Exam_Code":68,"Exam_Name":"FLEX 중국어"},{"Lang_Code":27,"Exam_Code":69,"Exam_Name":"FLEX 프랑스어"},{"Lang_Code":7,"Exam_Code":70,"Exam_Name":"FLEX 마인어"},{"Lang_Code":7,"Exam_Code":71,"Exam_Name":"OPI"},{"Lang_Code":10,"Exam_Code":72,"Exam_Name":"FLEX 베트남어"},{"Lang_Code":10,"Exam_Code":73,"Exam_Name":"OPI"},{"Lang_Code":10,"Exam_Code":74,"Exam_Name":"OPIc"}]'
      )
    );
    var examGradeCollection = Backbone.Collection.extend({
      byExamCode: function (examCode) {
        return this.filter(function (m) {
          return m.get("Exam_Code") == examCode;
        });
      },
    });

    var examGradeCollection = new examGradeCollection(
      JSON.parse(
        '[{"Exam_Code":5,"Code":1,"Name":"취득"},{"Exam_Code":39,"Code":4,"Name":"AL"},{"Exam_Code":30,"Code":4,"Name":"AL"},{"Exam_Code":26,"Code":4,"Name":"A1"},{"Exam_Code":38,"Code":4,"Name":"AL"},{"Exam_Code":40,"Code":4,"Name":"AL"},{"Exam_Code":48,"Code":4,"Name":"AL"},{"Exam_Code":74,"Code":4,"Name":"AL"},{"Exam_Code":74,"Code":5,"Name":"IH"},{"Exam_Code":48,"Code":5,"Name":"IH"},{"Exam_Code":40,"Code":5,"Name":"IH"},{"Exam_Code":38,"Code":5,"Name":"IH"},{"Exam_Code":26,"Code":5,"Name":"A2"},{"Exam_Code":30,"Code":5,"Name":"IH"},{"Exam_Code":39,"Code":5,"Name":"IH"},{"Exam_Code":6,"Code":1,"Name":"A1"},{"Exam_Code":6,"Code":2,"Name":"A2"},{"Exam_Code":39,"Code":13,"Name":"IM3"},{"Exam_Code":38,"Code":13,"Name":"IM3"},{"Exam_Code":26,"Code":6,"Name":"B1"},{"Exam_Code":74,"Code":13,"Name":"IM3"},{"Exam_Code":30,"Code":13,"Name":"IM3"},{"Exam_Code":48,"Code":13,"Name":"IM3"},{"Exam_Code":40,"Code":13,"Name":"IM3"},{"Exam_Code":39,"Code":12,"Name":"IM2"},{"Exam_Code":30,"Code":12,"Name":"IM2"},{"Exam_Code":38,"Code":12,"Name":"IM2"},{"Exam_Code":40,"Code":12,"Name":"IM2"},{"Exam_Code":48,"Code":12,"Name":"IM2"},{"Exam_Code":74,"Code":12,"Name":"IM2"},{"Exam_Code":26,"Code":7,"Name":"B2"},{"Exam_Code":7,"Code":1,"Name":"취득"},{"Exam_Code":9,"Code":1,"Name":"취득"},{"Exam_Code":39,"Code":11,"Name":"IM1"},{"Exam_Code":30,"Code":11,"Name":"IM1"},{"Exam_Code":26,"Code":8,"Name":"C1"},{"Exam_Code":48,"Code":11,"Name":"IM1"},{"Exam_Code":74,"Code":11,"Name":"IM1"},{"Exam_Code":40,"Code":11,"Name":"IM1"},{"Exam_Code":38,"Code":11,"Name":"IM1"},{"Exam_Code":48,"Code":7,"Name":"IL"},{"Exam_Code":40,"Code":7,"Name":"IL"},{"Exam_Code":26,"Code":9,"Name":"C2"},{"Exam_Code":39,"Code":7,"Name":"IL"},{"Exam_Code":11,"Code":1,"Name":"취득"},{"Exam_Code":38,"Code":7,"Name":"IL"},{"Exam_Code":74,"Code":7,"Name":"IL"},{"Exam_Code":30,"Code":7,"Name":"IL"},{"Exam_Code":30,"Code":8,"Name":"NH"},{"Exam_Code":74,"Code":8,"Name":"NH"},{"Exam_Code":38,"Code":8,"Name":"NH"},{"Exam_Code":12,"Code":1,"Name":"취득"},{"Exam_Code":26,"Code":1,"Name":"초"},{"Exam_Code":39,"Code":8,"Name":"NH"},{"Exam_Code":40,"Code":8,"Name":"NH"},{"Exam_Code":48,"Code":8,"Name":"NH"},{"Exam_Code":48,"Code":9,"Name":"NM"},{"Exam_Code":40,"Code":9,"Name":"NM"},{"Exam_Code":39,"Code":9,"Name":"NM"},{"Exam_Code":26,"Code":2,"Name":"중"},{"Exam_Code":38,"Code":9,"Name":"NM"},{"Exam_Code":74,"Code":9,"Name":"NM"},{"Exam_Code":30,"Code":9,"Name":"NM"},{"Exam_Code":30,"Code":10,"Name":"NL"},{"Exam_Code":74,"Code":10,"Name":"NL"},{"Exam_Code":38,"Code":10,"Name":"NL"},{"Exam_Code":26,"Code":3,"Name":"고"},{"Exam_Code":39,"Code":10,"Name":"NL"},{"Exam_Code":40,"Code":10,"Name":"NL"},{"Exam_Code":48,"Code":10,"Name":"NL"},{"Exam_Code":29,"Code":1,"Name":"1"},{"Exam_Code":29,"Code":2,"Name":"2"},{"Exam_Code":29,"Code":3,"Name":"3"},{"Exam_Code":29,"Code":4,"Name":"4"},{"Exam_Code":29,"Code":5,"Name":"5"},{"Exam_Code":29,"Code":6,"Name":"6"},{"Exam_Code":29,"Code":7,"Name":"7"},{"Exam_Code":29,"Code":8,"Name":"8"},{"Exam_Code":29,"Code":9,"Name":"9"},{"Exam_Code":28,"Code":1,"Name":"1"},{"Exam_Code":28,"Code":2,"Name":"2"},{"Exam_Code":28,"Code":3,"Name":"3"},{"Exam_Code":28,"Code":4,"Name":"4"},{"Exam_Code":28,"Code":5,"Name":"5"},{"Exam_Code":28,"Code":6,"Name":"6"},{"Exam_Code":28,"Code":7,"Name":"7"},{"Exam_Code":28,"Code":8,"Name":"8"},{"Exam_Code":13,"Code":1,"Name":"1"},{"Exam_Code":13,"Code":2,"Name":"2"},{"Exam_Code":13,"Code":3,"Name":"3"},{"Exam_Code":13,"Code":4,"Name":"4"},{"Exam_Code":20,"Code":1,"Name":"1"},{"Exam_Code":20,"Code":2,"Name":"2"},{"Exam_Code":20,"Code":3,"Name":"3"},{"Exam_Code":20,"Code":4,"Name":"4"},{"Exam_Code":27,"Code":1,"Name":"1"},{"Exam_Code":27,"Code":2,"Name":"2"},{"Exam_Code":27,"Code":3,"Name":"3"},{"Exam_Code":27,"Code":4,"Name":"4"},{"Exam_Code":34,"Code":1,"Name":"N1"},{"Exam_Code":34,"Code":2,"Name":"N2"},{"Exam_Code":34,"Code":3,"Name":"N3"},{"Exam_Code":34,"Code":4,"Name":"N4"},{"Exam_Code":34,"Code":5,"Name":"N5"},{"Exam_Code":37,"Code":1,"Name":"1"},{"Exam_Code":37,"Code":2,"Name":"2"},{"Exam_Code":37,"Code":3,"Name":"3"},{"Exam_Code":37,"Code":4,"Name":"4"},{"Exam_Code":37,"Code":5,"Name":"5"},{"Exam_Code":37,"Code":6,"Name":"6"},{"Exam_Code":37,"Code":7,"Name":"7"},{"Exam_Code":37,"Code":8,"Name":"8"},{"Exam_Code":37,"Code":9,"Name":"9"},{"Exam_Code":37,"Code":10,"Name":"10"},{"Exam_Code":32,"Code":1,"Name":"1"},{"Exam_Code":32,"Code":2,"Name":"2"},{"Exam_Code":32,"Code":3,"Name":"3"},{"Exam_Code":32,"Code":4,"Name":"4"},{"Exam_Code":32,"Code":5,"Name":"5"},{"Exam_Code":32,"Code":6,"Name":"6"},{"Exam_Code":42,"Code":1,"Name":"1"},{"Exam_Code":42,"Code":2,"Name":"2"},{"Exam_Code":42,"Code":3,"Name":"3"},{"Exam_Code":42,"Code":4,"Name":"4"},{"Exam_Code":42,"Code":5,"Name":"5"},{"Exam_Code":8,"Code":1,"Name":"1"},{"Exam_Code":8,"Code":2,"Name":"2"},{"Exam_Code":8,"Code":3,"Name":"3"},{"Exam_Code":8,"Code":4,"Name":"4"},{"Exam_Code":8,"Code":5,"Name":"5"},{"Exam_Code":8,"Code":6,"Name":"6"},{"Exam_Code":8,"Code":7,"Name":"7"},{"Exam_Code":8,"Code":8,"Name":"8"},{"Exam_Code":8,"Code":9,"Name":"9"},{"Exam_Code":8,"Code":10,"Name":"10"},{"Exam_Code":8,"Code":11,"Name":"11"},{"Exam_Code":36,"Code":1,"Name":"1"},{"Exam_Code":36,"Code":2,"Name":"2"},{"Exam_Code":36,"Code":3,"Name":"3"},{"Exam_Code":36,"Code":4,"Name":"4"},{"Exam_Code":36,"Code":5,"Name":"5"},{"Exam_Code":36,"Code":6,"Name":"6"},{"Exam_Code":36,"Code":7,"Name":"7"},{"Exam_Code":36,"Code":8,"Name":"8"},{"Exam_Code":36,"Code":9,"Name":"9"},{"Exam_Code":36,"Code":10,"Name":"10"},{"Exam_Code":33,"Code":1,"Name":"초"},{"Exam_Code":33,"Code":2,"Name":"중"},{"Exam_Code":33,"Code":3,"Name":"고"},{"Exam_Code":35,"Code":1,"Name":"초"},{"Exam_Code":35,"Code":2,"Name":"중"},{"Exam_Code":35,"Code":3,"Name":"고"},{"Exam_Code":25,"Code":1,"Name":"기초단계"},{"Exam_Code":25,"Code":2,"Name":"기본단계"},{"Exam_Code":25,"Code":3,"Name":"1단계"},{"Exam_Code":25,"Code":4,"Name":"2단계"},{"Exam_Code":25,"Code":5,"Name":"3단계"},{"Exam_Code":25,"Code":6,"Name":"4단계"},{"Exam_Code":44,"Code":1,"Name":"1"},{"Exam_Code":44,"Code":2,"Name":"2"},{"Exam_Code":44,"Code":3,"Name":"3"},{"Exam_Code":44,"Code":4,"Name":"4"},{"Exam_Code":44,"Code":5,"Name":"5"},{"Exam_Code":46,"Code":1,"Name":"1"},{"Exam_Code":46,"Code":2,"Name":"2+"},{"Exam_Code":46,"Code":3,"Name":"2-"},{"Exam_Code":46,"Code":4,"Name":"3+"},{"Exam_Code":46,"Code":5,"Name":"3-"},{"Exam_Code":46,"Code":6,"Name":"4+"},{"Exam_Code":46,"Code":7,"Name":"4-"},{"Exam_Code":47,"Code":1,"Name":"1"},{"Exam_Code":47,"Code":2,"Name":"2"},{"Exam_Code":47,"Code":3,"Name":"3"},{"Exam_Code":47,"Code":4,"Name":"4"},{"Exam_Code":47,"Code":5,"Name":"5"},{"Exam_Code":47,"Code":6,"Name":"6"},{"Exam_Code":60,"Code":1,"Name":"A1"},{"Exam_Code":60,"Code":2,"Name":"A2"},{"Exam_Code":60,"Code":3,"Name":"B1"},{"Exam_Code":60,"Code":4,"Name":"B2"},{"Exam_Code":60,"Code":5,"Name":"C1"},{"Exam_Code":60,"Code":6,"Name":"C2"},{"Exam_Code":53,"Code":1,"Name":"3C"},{"Exam_Code":53,"Code":2,"Name":"3B"},{"Exam_Code":53,"Code":3,"Name":"3A"},{"Exam_Code":53,"Code":4,"Name":"2C"},{"Exam_Code":53,"Code":5,"Name":"2B"},{"Exam_Code":53,"Code":6,"Name":"2A"},{"Exam_Code":53,"Code":7,"Name":"1C"},{"Exam_Code":53,"Code":8,"Name":"1B"},{"Exam_Code":53,"Code":9,"Name":"1A"},{"Exam_Code":65,"Code":1,"Name":"3C"},{"Exam_Code":65,"Code":2,"Name":"3B"},{"Exam_Code":65,"Code":3,"Name":"3A"},{"Exam_Code":65,"Code":4,"Name":"2C"},{"Exam_Code":65,"Code":5,"Name":"2B"},{"Exam_Code":65,"Code":6,"Name":"2A"},{"Exam_Code":65,"Code":7,"Name":"1C"},{"Exam_Code":65,"Code":8,"Name":"1B"},{"Exam_Code":65,"Code":9,"Name":"1A"},{"Exam_Code":63,"Code":1,"Name":"NL"},{"Exam_Code":63,"Code":2,"Name":"NM"},{"Exam_Code":63,"Code":3,"Name":"NH"},{"Exam_Code":63,"Code":4,"Name":"IL"},{"Exam_Code":63,"Code":5,"Name":"IM"},{"Exam_Code":63,"Code":6,"Name":"IH"},{"Exam_Code":63,"Code":7,"Name":"AL"},{"Exam_Code":64,"Code":1,"Name":"3C"},{"Exam_Code":64,"Code":2,"Name":"3B"},{"Exam_Code":64,"Code":3,"Name":"3A"},{"Exam_Code":64,"Code":4,"Name":"2C"},{"Exam_Code":64,"Code":5,"Name":"2B"},{"Exam_Code":64,"Code":6,"Name":"2A"},{"Exam_Code":64,"Code":7,"Name":"1C"},{"Exam_Code":64,"Code":8,"Name":"1B"},{"Exam_Code":64,"Code":9,"Name":"1A"},{"Exam_Code":67,"Code":1,"Name":"3C"},{"Exam_Code":67,"Code":2,"Name":"3B"},{"Exam_Code":67,"Code":3,"Name":"3A"},{"Exam_Code":67,"Code":4,"Name":"2C"},{"Exam_Code":67,"Code":5,"Name":"2B"},{"Exam_Code":67,"Code":6,"Name":"2A"},{"Exam_Code":67,"Code":7,"Name":"1C"},{"Exam_Code":67,"Code":8,"Name":"1B"},{"Exam_Code":67,"Code":9,"Name":"1A"},{"Exam_Code":68,"Code":1,"Name":"3C"},{"Exam_Code":68,"Code":2,"Name":"3B"},{"Exam_Code":68,"Code":3,"Name":"3A"},{"Exam_Code":68,"Code":4,"Name":"2C"},{"Exam_Code":68,"Code":5,"Name":"2B"},{"Exam_Code":68,"Code":6,"Name":"2A"},{"Exam_Code":68,"Code":7,"Name":"1C"},{"Exam_Code":68,"Code":8,"Name":"1B"},{"Exam_Code":68,"Code":9,"Name":"1A"},{"Exam_Code":69,"Code":1,"Name":"3C"},{"Exam_Code":69,"Code":2,"Name":"3B"},{"Exam_Code":69,"Code":3,"Name":"3A"},{"Exam_Code":69,"Code":4,"Name":"2C"},{"Exam_Code":69,"Code":5,"Name":"2B"},{"Exam_Code":69,"Code":6,"Name":"2A"},{"Exam_Code":69,"Code":7,"Name":"1C"},{"Exam_Code":69,"Code":8,"Name":"1B"},{"Exam_Code":69,"Code":9,"Name":"1A"},{"Exam_Code":5,"Code":2,"Name":"C1"},{"Exam_Code":5,"Code":3,"Name":"C2"},{"Exam_Code":6,"Code":3,"Name":"B1"},{"Exam_Code":6,"Code":4,"Name":"B2"},{"Exam_Code":66,"Code":1,"Name":"3C"},{"Exam_Code":66,"Code":2,"Name":"3B"},{"Exam_Code":66,"Code":3,"Name":"3A"},{"Exam_Code":66,"Code":4,"Name":"2C"},{"Exam_Code":66,"Code":5,"Name":"2B"},{"Exam_Code":66,"Code":6,"Name":"2A"},{"Exam_Code":66,"Code":7,"Name":"1C"},{"Exam_Code":66,"Code":8,"Name":"1B"},{"Exam_Code":66,"Code":9,"Name":"1A"},{"Exam_Code":70,"Code":1,"Name":"3C"},{"Exam_Code":70,"Code":2,"Name":"3B"},{"Exam_Code":70,"Code":3,"Name":"3A"},{"Exam_Code":70,"Code":4,"Name":"2C"},{"Exam_Code":70,"Code":5,"Name":"2B"},{"Exam_Code":70,"Code":6,"Name":"2A"},{"Exam_Code":70,"Code":7,"Name":"1C"},{"Exam_Code":70,"Code":8,"Name":"1B"},{"Exam_Code":70,"Code":9,"Name":"1A"},{"Exam_Code":71,"Code":1,"Name":"S"},{"Exam_Code":71,"Code":2,"Name":"AH"},{"Exam_Code":71,"Code":3,"Name":"AM"},{"Exam_Code":71,"Code":4,"Name":"AL"},{"Exam_Code":71,"Code":5,"Name":"IH"},{"Exam_Code":71,"Code":6,"Name":"IM"},{"Exam_Code":71,"Code":7,"Name":"IL"},{"Exam_Code":71,"Code":8,"Name":"NH"},{"Exam_Code":71,"Code":9,"Name":"NM"},{"Exam_Code":71,"Code":10,"Name":"NL"},{"Exam_Code":72,"Code":1,"Name":"3C"},{"Exam_Code":72,"Code":2,"Name":"3B"},{"Exam_Code":72,"Code":3,"Name":"3A"},{"Exam_Code":72,"Code":4,"Name":"2C"},{"Exam_Code":72,"Code":5,"Name":"2B"},{"Exam_Code":72,"Code":6,"Name":"2A"},{"Exam_Code":72,"Code":7,"Name":"1C"},{"Exam_Code":72,"Code":8,"Name":"1B"},{"Exam_Code":72,"Code":9,"Name":"1A"},{"Exam_Code":73,"Code":1,"Name":"S"},{"Exam_Code":73,"Code":2,"Name":"AH"},{"Exam_Code":73,"Code":3,"Name":"AM"},{"Exam_Code":73,"Code":4,"Name":"AL"},{"Exam_Code":73,"Code":5,"Name":"IH"},{"Exam_Code":73,"Code":6,"Name":"IM"},{"Exam_Code":73,"Code":7,"Name":"IL"},{"Exam_Code":73,"Code":8,"Name":"NH"},{"Exam_Code":73,"Code":9,"Name":"NM"},{"Exam_Code":73,"Code":10,"Name":"NL"},{"Exam_Code":28,"Code":9,"Name":"AH"},{"Exam_Code":28,"Code":10,"Name":"AM"},{"Exam_Code":28,"Code":11,"Name":"AL"},{"Exam_Code":28,"Code":12,"Name":"IH"},{"Exam_Code":28,"Code":13,"Name":"IM3"},{"Exam_Code":28,"Code":14,"Name":"IM2"},{"Exam_Code":28,"Code":15,"Name":"IM1"},{"Exam_Code":28,"Code":16,"Name":"IL"},{"Exam_Code":28,"Code":17,"Name":"NH"},{"Exam_Code":28,"Code":18,"Name":"NM/NL"},{"Exam_Code":77,"Code":1,"Name":"AH"},{"Exam_Code":77,"Code":2,"Name":"AM"},{"Exam_Code":77,"Code":3,"Name":"AL"},{"Exam_Code":77,"Code":4,"Name":"IH"},{"Exam_Code":77,"Code":5,"Name":"IM3"},{"Exam_Code":77,"Code":6,"Name":"IM2"},{"Exam_Code":77,"Code":7,"Name":"IM1"},{"Exam_Code":77,"Code":8,"Name":"IL"},{"Exam_Code":77,"Code":9,"Name":"NH"},{"Exam_Code":77,"Code":10,"Name":"NM/NL"},{"Exam_Code":78,"Code":1,"Name":"초"},{"Exam_Code":78,"Code":2,"Name":"중"},{"Exam_Code":78,"Code":3,"Name":"고"},{"Exam_Code":79,"Code":1,"Name":"S"},{"Exam_Code":79,"Code":2,"Name":"AH"},{"Exam_Code":79,"Code":3,"Name":"AM"},{"Exam_Code":79,"Code":4,"Name":"AL"},{"Exam_Code":79,"Code":5,"Name":"IH"},{"Exam_Code":79,"Code":6,"Name":"IM"},{"Exam_Code":79,"Code":7,"Name":"IL"},{"Exam_Code":79,"Code":8,"Name":"NH"},{"Exam_Code":79,"Code":9,"Name":"NM"},{"Exam_Code":79,"Code":10,"Name":"NL"},{"Exam_Code":80,"Code":1,"Name":"S"},{"Exam_Code":80,"Code":2,"Name":"AH"},{"Exam_Code":80,"Code":3,"Name":"AM"},{"Exam_Code":80,"Code":4,"Name":"AL"},{"Exam_Code":80,"Code":5,"Name":"IH"},{"Exam_Code":80,"Code":6,"Name":"IM"},{"Exam_Code":80,"Code":7,"Name":"IL"},{"Exam_Code":80,"Code":8,"Name":"NH"},{"Exam_Code":80,"Code":9,"Name":"NM"},{"Exam_Code":80,"Code":10,"Name":"NL"},{"Exam_Code":81,"Code":1,"Name":"S"},{"Exam_Code":81,"Code":2,"Name":"AH"},{"Exam_Code":81,"Code":3,"Name":"AM"},{"Exam_Code":81,"Code":4,"Name":"AL"},{"Exam_Code":81,"Code":5,"Name":"IH"},{"Exam_Code":81,"Code":6,"Name":"IM"},{"Exam_Code":81,"Code":7,"Name":"IL"},{"Exam_Code":81,"Code":8,"Name":"NH"},{"Exam_Code":81,"Code":9,"Name":"NM"},{"Exam_Code":81,"Code":10,"Name":"NL"},{"Exam_Code":82,"Code":1,"Name":"S"},{"Exam_Code":82,"Code":2,"Name":"AH"},{"Exam_Code":82,"Code":3,"Name":"AM"},{"Exam_Code":82,"Code":4,"Name":"AL"},{"Exam_Code":82,"Code":5,"Name":"IH"},{"Exam_Code":82,"Code":6,"Name":"IM"},{"Exam_Code":82,"Code":7,"Name":"IL"},{"Exam_Code":82,"Code":8,"Name":"NH"},{"Exam_Code":82,"Code":9,"Name":"NM"},{"Exam_Code":82,"Code":10,"Name":"NL"},{"Exam_Code":83,"Code":1,"Name":"S"},{"Exam_Code":83,"Code":2,"Name":"AH"},{"Exam_Code":83,"Code":3,"Name":"AM"},{"Exam_Code":83,"Code":4,"Name":"AL"},{"Exam_Code":83,"Code":5,"Name":"IH"},{"Exam_Code":83,"Code":6,"Name":"IM"},{"Exam_Code":83,"Code":7,"Name":"IL"},{"Exam_Code":83,"Code":8,"Name":"NH"},{"Exam_Code":83,"Code":9,"Name":"NM"},{"Exam_Code":83,"Code":10,"Name":"NL"},{"Exam_Code":84,"Code":1,"Name":"S"},{"Exam_Code":84,"Code":2,"Name":"AH"},{"Exam_Code":84,"Code":3,"Name":"AM"},{"Exam_Code":84,"Code":4,"Name":"AL"},{"Exam_Code":84,"Code":5,"Name":"IH"},{"Exam_Code":84,"Code":6,"Name":"IM"},{"Exam_Code":84,"Code":7,"Name":"IL"},{"Exam_Code":84,"Code":8,"Name":"NH"},{"Exam_Code":84,"Code":9,"Name":"NM"},{"Exam_Code":84,"Code":10,"Name":"NL"},{"Exam_Code":85,"Code":1,"Name":"S"},{"Exam_Code":85,"Code":2,"Name":"AH"},{"Exam_Code":85,"Code":3,"Name":"AM"},{"Exam_Code":85,"Code":4,"Name":"AL"},{"Exam_Code":85,"Code":5,"Name":"IH"},{"Exam_Code":85,"Code":6,"Name":"IM"},{"Exam_Code":85,"Code":7,"Name":"IL"},{"Exam_Code":85,"Code":8,"Name":"NH"},{"Exam_Code":85,"Code":9,"Name":"NM"},{"Exam_Code":85,"Code":10,"Name":"NL"},{"Exam_Code":86,"Code":1,"Name":"AL"},{"Exam_Code":86,"Code":2,"Name":"IH"},{"Exam_Code":86,"Code":3,"Name":"IM3"},{"Exam_Code":86,"Code":4,"Name":"IM2"},{"Exam_Code":86,"Code":5,"Name":"IM1"},{"Exam_Code":86,"Code":6,"Name":"IL"},{"Exam_Code":86,"Code":7,"Name":"NH"},{"Exam_Code":86,"Code":8,"Name":"NM"},{"Exam_Code":86,"Code":9,"Name":"NL"}]'
      )
    );
    var LanugaeView = Backbone.View.extend({
      el: "#language_containers",
      initialize: function (options) {
        var that = this;
        _.extend(this, options);
        this.template = _.template($("#tplLanguageItem").html());
        if (this.collection.size() == 0) {
          that.addItemClick();
        }
        this.$el
          .closest(".form")
          .find(".buttonAddField")
          .click(function (e) {
            that.addItemClick(e);
          });
        this.render();
        Resume.Utilities.setValueDropdown(
          this.$el.find(".dropdown")
        );
      },
      events: {
        "click .dropdown-category .list button": "categoryClick", //회화능력/공인 시험 선택
        "click .dropdown-language-name .list button":
          "languageClick", //외국어명 선택
        "click .dropdown-language-category .list button":
          "examClick", //시험 선택
        "click .dropdown-grade-category .list button":
          "gradeCategoryClick", //점/급수/취득 선택
        "click .buttonDeleteField": "delItemClick", //항목 삭제
      },
      render: function () {
        var that = this;
        this.collection.each(function (item) {
          that.addCollectionItem(item);
          that.categorySelect(
            $("#language_containers .container:last")
          );
          that.languageSelect(
            $("#language_containers .container:last")
          );
          that.examSelect(
            $("#language_containers .container:last")
          );
        }, this);
      },
      getRowNo: function () {
        return this.$(".container").size() + 1;
      },
      addItemClick: function () {
        this.addCollectionItem(new this.collection.model());
      },
      addCollectionItem: function (item) {
        var that = this,
          testCode = item.get("Test1_Name"),
          conversationLevel = item.get("Lang1_Stat");

        var no = this.getRowNo();
        var templateData = _.extend({
          data: item.toJSON(),
          cid: item.cid,
          no: no,
        });
        this.$el.append(this.template(templateData));

        var temp_id = "#Language_Test1_Point_I_" + item.cid;

        if (item.toJSON().Point_Grade_Type_Code == 3) {
          setTimeout(function () {
            $(temp_id).parent(".devExamGradeInput").hide();
          }, 100);
        }

        var $newRow = this.$el.find(".container" + no);
        $newRow.find(".dropdown-category button").focus();
      },
      delItemClick: function (e) {
        var $btn = $(e.currentTarget),
          $container = $btn.closest(".container"),
          $form = $container.closest(".form"),
          cid = $container.data("cid");

        this.collection.remove(this.collection.get(cid));
        $container.remove();

        if ($form.find(".container").length == 0)
          $("#InputStat_LanguageInputStat").val("False");
      },
      categoryClick: function (e) {
        var $source = $(e.currentTarget),
          value = $source.data("value"),
          $container = $source.closest(".container"),
          $hidden = $source
            .closest(".dropdown")
            .find("input[type='hidden']"),
          $devExamArea = $container.find(".devExamArea"),
          $devConversationArea = $container.find(
            ".devConversationArea"
          );

        $hidden.val(value);
        Resume.Utilities.clearValueDropdownLabelByHtml(
          $container.find(".dropdown-language-name")
        );
        this.categorySelect($container);
        $devExamArea.find(".dropdown").each(function () {
          Resume.Utilities.clearValueDropdownLabelByHtml($(this));
        });
        Resume.Utilities.clearValueDropdownLabelByHtml(
          $devConversationArea.find(".dropdown")
        );
        this.languageSelect($container);
        this.examSelect($container);
      },
      languageClick: function (e) {
        var $source = $(e.currentTarget),
          $dropdown = $source.closest(".dropdown"),
          value = $source.data("value"),
          $hidden = $dropdown.find("input[type='hidden']"),
          $container = $source.closest(".container"),
          $devExamArea = $container.find(".devExamArea"),
          $devConversationArea = $container.find(
            ".devConversationArea"
          );

        //동일한 언어에 회화 능력을 선택한 것이 있는지 체크
        var curEvalType = $container
          .find("[id^='Language_Eval_Category']")
          .val();
        var curLanguageCode = value;
        var dupleFlag = false;

        if (curEvalType == "1" && value != 31) {
          this.$el
            .find("[id^='Language_Eval_Category'][value='1']")
            .each(function () {
              var $otherLanguageEle = $(this)
                .closest(".container")
                .find(
                  ".dropdown-language-name input[type='hidden']"
                );
              if (
                $hidden.attr("id") != $otherLanguageEle.attr("id")
              ) {
                var otherLanguageCode = $otherLanguageEle.val();
                if (otherLanguageCode == curLanguageCode) {
                  dupleFlag = true;
                }
              }
            });
        }

        $hidden.val(value);
        if (dupleFlag) {
          $container.find(".dropdown-category :button").focus();
          Resume.Utilities.validationMsgShow(
            $dropdown,
            "이미 동일한 언어의<br/>회화능력을 입력했어요."
          );
        } else {
          $devExamArea.find(".dropdown").each(function () {
            Resume.Utilities.clearValueDropdownLabelByHtml($(this));
          });
          $devExamArea.find(".input").each(function () {
            //console.log($(this));
            Resume.Utilities.clearValueInput($(this));
          });
          $devConversationArea.find(".dropdown").each(function () {
            Resume.Utilities.clearValueDropdownLabelByHtml($(this));
          });

          this.languageSelect($container, true);
        }
      },
      examClick: function (e) {
        var $source = $(e.currentTarget),
          $dropdown = $source.closest(".dropdown"),
          $container = $source.closest(".container"),
          value = $source.data("value"),
          $hidden = $dropdown.find("input[type='hidden']"),
          $examGradeDropdown = $container.find(
            ".devExamGradeDropdown"
          ),
          $examGradeInput = $container.find(".devExamGradeInput");

        $hidden.val(value);
        Resume.Utilities.clearValueDropdownLabelByHtml(
          $examGradeDropdown
        );
        Resume.Utilities.clearValueInput($examGradeInput);
        this.examSelect($container, true);
      },
      gradeCategoryClick: function (e) {
        var $source = $(e.currentTarget),
          $container = $source.closest(".container"),
          value = $source.data("value");
        if (value == 3) {
          $source.closest(".container").find(".input-grade").hide();
        } else {
          $source.closest(".container").find(".input-grade").show();
        }
      },
      categorySelect: function ($container) {
        var that = this,
          $ele = $container.find("[id^='Language_Eval_Category']"),
          $devExamArea = $container.find(".devExamArea"),
          $devConversationArea = $container.find(
            ".devConversationArea"
          ),
          $languageNameDrop = $container.find(
            ".devLanguageDropdown"
          ),
          $examGradeCategoryDropdown = $container.find(
            ".devExamGradeCategoryDropdown"
          ),
          category = $ele.val();

        $languageNameDrop.show();
        $examGradeCategoryDropdown.hide();
        //$examGradeCategoryDropdown.find("input[id^='Language_Point_Grade_Type_Code_D_']").val("");

        //회화 능력
        if (category == "1") {
          $devConversationArea.show();
          $devExamArea.hide();
        } else if (category == "2") {
          $devConversationArea.hide();
          $devExamArea.show();
          Resume.Utilities.clearValueDropdownLabelByHtml(
            $devConversationArea.find(".dropdown")
          );
        }
      },
      languageSelect: function ($container, isClickEvent) {
        var that = this,
          languageCode = $container
            .find("input[id^='Language_Lang1_Name_']")
            .val(),
          evalType = $container
            .find("input[id^='Language_Eval_Category']")
            .val(),
          $testNameInput = $container
            .find("input[id^='Language_Test_Etc_']")
            .closest(".input"),
          $testNameDrop = $container
            .find("input[id^='Language_Test1_Name_']")
            .closest(".dropdown"),
          $languageNameInput = $container
            .find("input[id^='Language_Lang_Etc_']")
            .closest(".input"),
          $languageNameDrop = $container
            .find("input[id^='Language_Lang1_Name_']")
            .closest(".dropdown"),
          $examGradeCategoryDropdown = $container.find(
            ".devExamGradeCategoryDropdown"
          ),
          $listWrap = $testNameDrop.find(".list ul");

        $examGradeCategoryDropdown.hide();
        //$examGradeCategoryDropdown.find("input[id^='Language_Point_Grade_Type_Code_D_']").val("");

        if (languageCode == 31) {
          $languageNameDrop.hide();
          $languageNameInput.show();
          if (isClickEvent) {
            $languageNameInput.find("input").trigger("focus");
          }
        } else {
          $languageNameInput.find(":text").val("");
          $languageNameInput.hide();
        }

        //구분이 공인 시험이면..
        if (evalType == "2") {
          $testNameInput.hide();
          $testNameDrop.hide();

          var result =
            that.languageExamCollection.byLangCode(languageCode);
          $listWrap.html("");

          //공인 시험이 없는 언어이면..
          if (result.length == 0) {
            $testNameInput.show();
            $testNameDrop.find("input[type='hidden']").val("99");
            Resume.Utilities.setValueDropdown($testNameDrop);
          } else {
            $testNameDrop.show();
            $(result).each(function () {
              var $item = this;
              $listWrap.append(
                _.template(
                  '<li><button type="button" class="button" data-value="<%=Exam_Code%>"><span><%=Exam_Name%></span></button></li>',
                  $item.toJSON()
                )
              );
            }, this);

            //공인 시험이 있는데 시험을 직접 입력이 가능한 언어이면..
            //if (that.isAllowExamCustomInput(languageCode)) {
            //    $listWrap.append('<li><button type="button" class="button" data-value="99"><span>직접입력</span></button></li>');
            //}
            $listWrap.append(
              '<li><button type="button" class="button" data-value="99"><span>직접입력</span></button></li>'
            );
            $testNameDrop.removeData("Dropdown");
            $testNameDrop.Dropdown();
          }

          // 영어인 경우 TOEIC S/W 숨기기
          /*if (languageCode == "16") {
                $listWrap.find("li").each(function () {
                    //console.log($(this).find("span").text());
                    //console.log($(this).find("button").data("value"));
                    var examCode = $(this).find("button").data("value");
                    if (examCode == "29") {
                        $(this).find("button").attr('disabled', true);
                        $(this).find("button").addClass("blind");
                    }
                });
            }*/
        }
        this.examSelect($container);
      },
      examSelect: function ($container, isClickEvent) {
        var that = this,
          $examDropdown = $container.find(".devExamDropdown"),
          $examGradeDropdown = $container.find(
            ".devExamGradeDropdown"
          ),
          $examGradeInput = $container.find(".devExamGradeInput"),
          examCode = $examDropdown
            .find("input[type='hidden']")
            .val(),
          $examGradeCategoryDropdown = $container.find(
            ".devExamGradeCategoryDropdown"
          ),
          $listWrap = $examGradeDropdown.find(".list ul");

        if (examCode) {
          var result =
            that.examGradeCollection.byExamCode(examCode);
          var $testNameInput = $container
            .find("input[id^='Language_Test_Etc_']")
            .closest(".input");
          $listWrap.html("");

          //시험명이 직접 입력이면
          if (examCode == "99") {
            $examDropdown.hide();
            $testNameInput.show();
            $examGradeCategoryDropdown.show();
            if (isClickEvent) {
              $testNameInput.find("input").trigger("focus");
            }
          } else if (
          /* 영어 G-TELP(GLT)와 G-TELP(GST)
           * 한국어 교원자격증, DSH, PWD, SD1, SD2, SNULT 독일어,
           * TCT 번역능력인정시험 독일어, TestDaF, ZOP, 관광통역안내사 독일어
           * 예외처리(기획팀 황시현선임 요청)
           */
            examCode == "15" ||
            examCode == "16" ||
            examCode == "75" ||
            examCode == "76" ||
            examCode == "45" ||
            examCode == "52" ||
            examCode == "54" ||
            examCode == "55" ||
            examCode == "56" ||
            examCode == "57" ||
            examCode == "58" ||
            examCode == "59" ||
            examCode == "61" ||
            examCode == "62"
          ) {
            $examGradeCategoryDropdown.show();
            if (isClickEvent) {
              $testNameInput.find("input").trigger("focus");
            }
          } else {
            $testNameInput.find(":text").val("");
            $testNameInput.hide();
          }

          //시험 성적이 선택항목이 없으면.
          if (result == null || result.length == 0) {
            $examGradeDropdown.hide();
            $examGradeInput.show();
            Resume.Utilities.clearValueDropdownLabelByHtml(
              $examGradeDropdown
            );
            $examGradeDropdown
              .find("input[type='hidden']")
              .val("")
              .attr("disabled", true);
            $examGradeInput
              .find("input[type='text']")
              .attr("disabled", false);
          } else {
            Resume.Utilities.clearValueInput($examGradeInput);
            $examGradeInput.hide();
            $examGradeDropdown.show();
            $(result).each(function () {
              var $item = this;
              $listWrap.append(
                _.template(
                  '<li><button type="button" class="button" data-value="<%=Code%>"><span><%=Name%></span></button></li>',
                  $item.toJSON()
                )
              );
            }, this);

            $examGradeDropdown
              .find("input[type='hidden']")
              .attr("disabled", false);
            $examGradeInput
              .find("input[type='text']")
              .val("")
              .attr("disabled", true);

            $examGradeDropdown.removeData("Dropdown");
            $examGradeDropdown.Dropdown();
          }
        } else {
          Resume.Utilities.clearValueDropdownLabelByHtml(
            $examGradeDropdown
          );
          $examGradeDropdown
            .find("input[type='hidden']")
            .val("")
            .attr("disabled", true);
          $examGradeInput
            .find("input[type='text']")
            .attr("disabled", false);
          $examGradeInput.show();
          $examGradeDropdown.hide();
        }
      },
      isAllowExamCustomInput: function (languageCode) {
        //영어, 일본어, 중국어만 직접 입력 가능.
        return (
          languageCode == "16" ||
          languageCode == "20" ||
          languageCode == "21"
        );
      },
    });

    var languageView = new LanugaeView({
      collection: languageCollection,
      languageExamCollection: languageExamCollection,
      examGradeCollection: examGradeCollection,
    });
  });