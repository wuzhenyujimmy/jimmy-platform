package com.jimmy.web.taglib;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.util.CollectionUtils;

import com.jimmy.module.common.Tag;

public class TreeTag extends BaseFlatUITag {

    private static final String FIRST_LEVEL_MAP_KEY = "";

    private Map<String, List<Tag>> treeMap;

    @Override
    public String getHtmlContent() {
        StringBuilder sb = new StringBuilder();

        List<Tag> firstLevelTags = treeMap.get(FIRST_LEVEL_MAP_KEY);

        appendChildNodes(firstLevelTags, sb);

        return sb.toString();
    }

    private void appendChildNodes(List<Tag> tags, StringBuilder sb) {

        if (!CollectionUtils.isEmpty(tags)) {
            for (Tag tag : tags) {
                String node = buildTagNode(tag);
                sb.append(node);
                appendChildNodes(treeMap.get(tag.getId()), sb);
            }
        }
    }

    private String buildTagNode(Tag tag) {
        
        Set<Tag> children = tag.getChildren();
        
        String iconNode = "";
        if (!CollectionUtils.isEmpty(children)) {
            iconNode = "<i class='icon ion-chevron-right'></i>";
        }

        return 

        "<div class='tree-level" + tag.getLevel() + " tag-line'>" +

            iconNode +
    
            "<div class='f-left tag-id'>" + tag.getId() + "</div>" +
            "<div class='f-left tag-name'>" + tag.getName() + "</div>" + 
            "<div class='f-left tag-createDate'>" + tag.getCreateDate() + "</div>" + 
            "<div class='f-left tag-level'>" + tag.getLevel() + "</div>" + 
            
            "<div class='f-left tag-disable'>" + 
                "<a herf='tag/delete?id=${tag.id }'>" + 
                    "<input type='button' class='btn btn-min btn-normal' value='Disable'>" + 
                "</a>" +
            "</div>" + 
                
            "<div class='f-left tag-update'>" + 
                "<a herf='tag/toupdate?id=${tag.id }'>" + 
                    "<input type='button' class='btn btn-min btn-normal' value='Update'>" + 
                "</a>" +
            "</div>" + 
            
            "<div class='f-left tag-add'>" + 
                "<a herf='tag/toadd?parentTagId=${tag.id }'>" + 
                    "<input type='button' class='btn btn-min btn-normal' value='Add'>" + 
                "</a>" +
            "</div>" + 
                
        "</div>";
    }

    public void setTreeMap(Map<String, List<Tag>> treeMap) {
        this.treeMap = treeMap;
    }

    public Map<String, List<Tag>> getTreeMap() {
        return treeMap;
    }
}
