package com.clife.dataplatform.upms.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Menuvo {
    Integer id;
    private String resName;
    private String resKey;
    private String resIcon;

    private List<Menuvo> children;
}
