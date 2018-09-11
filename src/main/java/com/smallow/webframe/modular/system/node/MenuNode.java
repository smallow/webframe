package com.smallow.webframe.modular.system.node;

import lombok.Data;

import java.util.List;

@Data
public class MenuNode {

    private Integer id;//节点id

    private String name;//节点名称

    private Integer parentId;//父节点ID

    private Integer level;  //级别

    private Integer orders; //排序序号

    private String url;

    private List<MenuNode> children;


}
