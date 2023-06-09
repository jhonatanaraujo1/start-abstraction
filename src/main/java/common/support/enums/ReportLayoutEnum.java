package common.support.enums;

import lombok.Getter;

@Getter
public enum ReportLayoutEnum {
    RETRATO(555),
    PAISAGEM(802);

    private final int largura;

    ReportLayoutEnum(int largura) {
        this.largura = largura;
    }
}
