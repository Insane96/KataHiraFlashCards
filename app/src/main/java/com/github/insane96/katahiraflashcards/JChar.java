package com.github.insane96.katahiraflashcards;

public enum JChar {
    A('あ', 'ア', "a"),
    I('い', 'イ', "i"),
    U('う', 'ウ', "u"),
    E('え', 'ェ', "e"),
    O('お', 'ォ', "o"),

    KA('か', 'カ', "ka"),
    KI('き', 'キ', "ki"),
    KU('く', 'ク', "ku"),
    KE('け', 'ケ', "ke"),
    KO('こ', 'コ', "ko"),

    GA('が', 'ガ', "ga"),
    GI('ぎ', 'ギ', "gi"),
    GU('ぐ', 'グ', "gu"),
    GE('げ', 'ゲ', "ge"),
    GO('ご', 'ゴ', "go"),

    SA('さ', 'サ', "sa"),
    SHI('し', 'シ', "shi"),
    SU('す', 'ス', "su"),
    SE('せ', 'セ', "se"),
    SO('そ', 'ソ', "so"),

    ZA('ざ', 'ザ', "za"),
    JI('じ', 'ジ', "ji"),
    ZU('ず', 'ズ', "zu"),
    ZE('ぜ', 'ゼ', "ze"),
    ZO('ぞ', 'ゾ', "zo"),

    TA('た', 'タ', "ta"),
    CHI('ち', 'チ', "chi"),
    TSU('つ', 'ツ', "tsu"),
    TE('て', 'テ', "te"),
    TO('と', 'ト', "to"),

    NA('な', 'ナ', "na"),
    NI('に', 'ニ', "ni"),
    NU('ぬ', 'ヌ', "nu"),
    NE('ね', 'ネ', "ne"),
    NO('の', 'ノ', "no"),

    HA('は', 'ハ', "ha"),
    HI('ひ', 'ヒ', "hi"),
    FU('ふ', 'フ', "fu"),
    HE('へ', 'ヘ', "he"),
    HO('ほ', 'ホ', "ho"),

    BA('ば', 'バ', "ba"),
    BI('び', 'ビ', "bi"),
    BU('ぶ', 'ブ', "bu"),
    BE('べ', 'ベ', "be"),
    BO('ぼ', 'ボ', "bo"),

    PA('ぱ', 'パ', "pa"),
    PI('ぴ', 'ピ', "pi"),
    PU('ぷ', 'プ', "pu"),
    PE('ぺ', 'ペ', "pe"),
    PO('ぽ', 'ポ', "po"),

    MA('ま', 'マ', "ma"),
    MI('み', 'ミ', "mi"),
    MU('む', 'ム', "mu"),
    ME('め', 'メ', "me"),
    MO('も', 'モ', "mo"),

    YA('や', 'ヤ', "ya"),
    YU('ゆ', 'ユ', "yu"),
    YO('よ', 'ヨ', "yo"),

    RA('ら', 'ラ', "ra"),
    RI('り', 'リ', "ri"),
    RU('る', 'ル', "ru"),
    RE('れ', 'レ', "re"),
    RO('ろ', 'ロ', "ro"),

    WA('わ', 'ワ', "wa"),
    WO('を', 'ヲ', "wo"),

    N('ん', 'ン', "n");

    public char hiragana;
    public char katakana;
    public String roomaji;

    JChar(char hiragana, char katakana, String roomaji) {
        this.hiragana = hiragana;
        this.katakana = katakana;
        this.roomaji = roomaji;
    }

    public char getHiragana() {
        return this.hiragana;
    }

    public char getKatakana() {
        return this.katakana;
    }

    public String getRoomaji() {
        return this.roomaji;
    }
}
