package com.github.insane96.katahiraflashcards;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public enum JGroup {
    VOWELS("vowels", List.of(JChar.A, JChar.I, JChar.U, JChar.E, JChar.O)),
    K("k", List.of(JChar.KA, JChar.KI, JChar.KU, JChar.KE, JChar.KO)),
    G("g", List.of(JChar.GA, JChar.GI, JChar.GU, JChar.GE, JChar.GO)),
    S("s", List.of(JChar.SA, JChar.SHI, JChar.SU, JChar.SE, JChar.SO)),
    Z("z", List.of(JChar.ZA, JChar.JI, JChar.ZU, JChar.ZE, JChar.ZO)),
    T("t", List.of(JChar.TA, JChar.CHI, JChar.TSU, JChar.TE, JChar.TO)),
    D("d", List.of(JChar.DA, JChar.DI, JChar.DU, JChar.DE, JChar.DO)),
    N("n", List.of(JChar.NA, JChar.NI, JChar.NU, JChar.NE, JChar.NO)),
    H("h", List.of(JChar.HA, JChar.HI, JChar.FU, JChar.HE, JChar.HO)),
    B("b", List.of(JChar.BA, JChar.BI, JChar.BU, JChar.BE, JChar.BO)),
    P("p", List.of(JChar.PA, JChar.PI, JChar.PU, JChar.PE, JChar.PO)),
    M("m", List.of(JChar.MA, JChar.MI, JChar.MU, JChar.ME, JChar.MO)),
    Y("y", List.of(JChar.YA, JChar.YU, JChar.YO)),
    R("r", List.of(JChar.RA, JChar.RI, JChar.RU, JChar.RE, JChar.RO)),
    WN("wn", List.of(JChar.WA, JChar.WO, JChar.N)),
    KY("ky", List.of(JChar.KYA, JChar.KYU, JChar.KYO)),
    SH("sh", List.of(JChar.SHA, JChar.SHU, JChar.SHO)),
    CH("ch", List.of(JChar.CHA, JChar.CHU, JChar.CHO)),
    NY("ny", List.of(JChar.NYA, JChar.NYU, JChar.NYO)),
    HY("hy", List.of(JChar.HYA, JChar.HYU, JChar.HYO)),
    MY("my", List.of(JChar.MYA, JChar.MYU, JChar.MYO)),
    RY("ry", List.of(JChar.RYA, JChar.RYU, JChar.RYO)),
    GY("gy", List.of(JChar.GYA, JChar.GYU, JChar.GYO)),
    JY("jy", List.of(JChar.JYA, JChar.JYU, JChar.JYO)),
    DY("dy", List.of(JChar.DYA, JChar.DYU, JChar.DYO)),
    BY("by", List.of(JChar.BYA, JChar.BYU, JChar.BYO)),
    PY("py", List.of(JChar.PYA, JChar.PYU, JChar.PYO));

    public static final Map<String, JGroup> NAME_MAP = new LinkedHashMap<>();

    public final String name;
    public final List<JChar> jChars;

    static {
        for (JGroup group : values()) {
            NAME_MAP.put(group.name, group);
        }
    }

    JGroup(String name, List<JChar> jChars) {
        this.name = name;
        this.jChars = jChars;
    }

    public static JGroup fromName(String name) {
        return NAME_MAP.get(name);
    }
}
