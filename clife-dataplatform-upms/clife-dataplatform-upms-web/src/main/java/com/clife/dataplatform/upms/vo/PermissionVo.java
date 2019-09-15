package com.clife.dataplatform.upms.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PermissionVo {

    /**
     * 主键
     */
    private Integer permissionId;

    /**
     * 名称
     */
    private String permissionName;

    /**
     * 资源类型，[menu|button]
     */
    private String resourceType;

    /**
     * 资源路径
     */
    private String url;

    /**
     * 权限字符串,menu例子：role:*，button例子：role:create,role:update,role:delete,role:view
     */
    private String permission;

    /**
     * 父编号
     */
    private Integer parentId;

    /**
     * 父编号列表
     */
    private String parentIds;

    /**
     * icon
     */
    private String resourceIcon;

    /**
     * 0:未上线；1:上线；2:删除
     */
    private int permissionStatus;

    /**
     * 子菜单权限
     */
    private List<PermissionVo> children;
}
