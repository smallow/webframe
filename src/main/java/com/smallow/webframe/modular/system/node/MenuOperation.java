package com.smallow.webframe.modular.system.node;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MenuOperation {

    public List<MenuNode> buildMenus(List<MenuNode> menusList) {
        List<MenuNode> roots = findRootNodes(menusList);
        roots.forEach(e -> e.setChildren(findChildNode(menusList, e.getId())));
        return roots;
    }

    private List<MenuNode> findChildNode(List<MenuNode> total, Integer parentId) {
//        return total.stream().filter(e -> e.getParentId() == parentId
//        ).collect(Collectors.toList());
        List<MenuNode> list = new ArrayList<>();
        for (MenuNode node : total) {
            if (node.getParentId() == parentId) {
                node.setChildren(findChildNode(total, node.getId()));
                list.add(node);
            }
        }
        return list;
    }

    /**
     * 获取最顶层根部节点
     *
     * @param list
     * @return
     */
    @Deprecated
    public MenuNode findRootNode(List<MenuNode> list) {
        Optional<MenuNode> optionalMenuNode = list.stream().filter(e -> e.getParentId() == 0).findFirst();
        if (optionalMenuNode.isPresent()) {
            return optionalMenuNode.get();
        }
        return null;
    }

    /**
     * 获取所有根部节点（level等于1）
     *
     * @param list
     * @return
     */
    public List<MenuNode> findRootNodes(List<MenuNode> list) {
        List<MenuNode> returnList = list.stream().filter(e -> e.getLevel() == 1).collect(Collectors.toList());
        //returnList.sort(Comparator.comparingInt(MenuNode::getOrders).reversed());  默认是升序,reversed翻转排序
        returnList.sort(Comparator.comparingInt(MenuNode::getOrders));
        return returnList;
    }


}
