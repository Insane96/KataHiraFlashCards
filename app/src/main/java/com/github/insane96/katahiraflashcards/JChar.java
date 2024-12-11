package com.github.insane96.katahiraflashcards;

import android.content.Context;

public enum JChar {
    A("あ", "ア", "a"),
    I("い", "イ", "i"),
    U("う", "ウ", "u"),
    E("え", "ェ", "e"),
    O("お", "ォ", "o"),

    KA("か", "カ", "ka"),
    KI("き", "キ", "ki"),
    KU("く", "ク", "ku"),
    KE("け", "ケ", "ke"),
    KO("こ", "コ", "ko"),

    GA("が", "ガ", "ga"),
    GI("ぎ", "ギ", "gi"),
    GU("ぐ", "グ", "gu"),
    GE("げ", "ゲ", "ge"),
    GO("ご", "ゴ", "go"),

    SA("さ", "サ", "sa"),
    SHI("し", "シ", "shi"),
    SU("す", "ス", "su"),
    SE("せ", "セ", "se"),
    SO("そ", "ソ", "so"),

    ZA("ざ", "ザ", "za"),
    JI("じ", "ジ", "ji"),
    ZU("ず", "ズ", "zu"),
    ZE("ぜ", "ゼ", "ze"),
    ZO("ぞ", "ゾ", "zo"),

    TA("た", "タ", "ta"),
    CHI("ち", "チ", "chi"),
    TSU("つ", "ツ", "tsu"),
    TE("て", "テ", "te"),
    TO("と", "ト", "to"),

    DA("だ", "ダ", "da"),
    DI("ぢ", "ヂ", "di"),
    DU("づ", "ヅ", "du"),
    DE("で", "デ", "de"),
    DO("ど", "ド", "do"),

    NA("な", "ナ", "na"),
    NI("に", "ニ", "ni"),
    NU("ぬ", "ヌ", "nu"),
    NE("ね", "ネ", "ne"),
    NO("の", "ノ", "no"),

    HA("は", "ハ", "ha"),
    HI("ひ", "ヒ", "hi"),
    FU("ふ", "フ", "fu"),
    HE("へ", "ヘ", "he"),
    HO("ほ", "ホ", "ho"),

    BA("ば", "バ", "ba"),
    BI("び", "ビ", "bi"),
    BU("ぶ", "ブ", "bu"),
    BE("べ", "ベ", "be"),
    BO("ぼ", "ボ", "bo"),

    PA("ぱ", "パ", "pa"),
    PI("ぴ", "ピ", "pi"),
    PU("ぷ", "プ", "pu"),
    PE("ぺ", "ペ", "pe"),
    PO("ぽ", "ポ", "po"),

    MA("ま", "マ", "ma"),
    MI("み", "ミ", "mi"),
    MU("む", "ム", "mu"),
    ME("め", "メ", "me"),
    MO("も", "モ", "mo"),

    YA("や", "ヤ", "ya"),
    YU("ゆ", "ユ", "yu"),
    YO("よ", "ヨ", "yo"),

    RA("ら", "ラ", "ra"),
    RI("り", "リ", "ri"),
    RU("る", "ル", "ru"),
    RE("れ", "レ", "re"),
    RO("ろ", "ロ", "ro"),

    WA("わ", "ワ", "wa"),
    WO("を", "ヲ", "wo"),
    N("ん", "ン", "n"),

    KYA("きゃ", "キャ", "kya"),
    KYU("きゅ", "キュ", "kyu"),
    KYO("きょ", "キョ", "kyo"),

    SHA("しゃ", "シャ", "sha"),
    SHU("しゅ", "シュ", "shu"),
    SHO("しょ", "ショ", "sho"),

    CHA("ちゃ", "チャ", "cha"),
    CHU("ちゅ", "チュ", "chu"),
    CHO("ちょ", "チョ", "cho"),

    NYA("にゃ", "ニャ", "nya"),
    NYU("にゅ", "ニュ", "nyu"),
    NYO("にょ", "ニョ", "nyo"),

    HYA("ひゃ", "ヒャ", "hya"),
    HYU("ひゅ", "ヒュ", "hyu"),
    HYO("ひょ", "ヒョ", "hyo"),

    MYA("みゃ", "ミャ", "mya"),
    MYU("みゅ", "ミュ", "myu"),
    MYO("みょ", "ミョ", "myo"),

    RYA("りゃ", "リャ", "rya"),
    RYU("りゅ", "リュ", "ryu"),
    RYO("りょ", "リョ", "ryo"),

    GYA("ぎゃ", "ギャ", "gya"),
    GYU("ぎゅ", "ギュ", "gyu"),
    GYO("ぎょ", "ギョ", "gyo"),

    JYA("じゃ", "ジャ", "jya"),
    JYU("じゅ", "ジュ", "jyu"),
    JYO("じょ", "ジョ", "jyo"),

    DYA("ぢゃ", "ヂャ", "dya"),
    DYU("ぢゅ", "ヂュ", "dyu"),
    DYO("ぢょ", "ヂョ", "dyo"),

    BYA("びゃ", "ビャ", "bya"),
    BYU("びゅ", "ビュ", "byu"),
    BYO("びょ", "ビョ", "byo"),

    PYA("ぴゃ", "ピャ", "pya"),
    PYU("ぴゅ", "ピュ", "pyu"),
    PYO("ぴょ", "ピョ", "pyo");

    public final String hiragana;
    public final String katakana;
    public final String roomaji;

    JChar(String hiragana, String katakana, String roomaji) {
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.roomaji = roomaji;
    }

    public int getRoomajiResId(Context context) {
        return context.getResources().getIdentifier("jchar_" + this.roomaji.toLowerCase(), "string", context.getPackageName());
    }
}
