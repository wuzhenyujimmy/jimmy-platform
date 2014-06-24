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
        
        String titleNode = 
        "<div class='tag-line'>" + 
            "<div class='f-left tag-name'>Name</div>" + 
            "<div class='f-left tag-level'>Level</div>" + 
            "<div class='f-left tag-child'>Child</div>" + 
            "<div class='f-left tag-createDate'>Create Time</div>" + 
        "</div>";
        
        sb.append(titleNode);

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
        
        String parentId = "";
        Tag parentTag = tag.getParent();
        if (null != parentTag) {
            parentId = parentTag.getId();
        }

        int childTagCount = 0;
        Set<Tag> childTags = tag.getChildren();
        if (!CollectionUtils.isEmpty(childTags)) {
            childTagCount = childTags.size();
        }

        return 

        "<div id='" + tag.getId() + "' class='tree-level" + tag.getLevel() + " tag-line' parent='" + parentId + "'>" +

            iconNode +
    
            "<div class='f-left tag-name'>" + tag.getName() + "</div>" + 
            "<div class='f-left tag-level'>" + tag.getLevel() + "</div>" + 
            "<div class='f-left tag-child'>( " + childTagCount + " )</div>" + 
            "<div class='f-left tag-createDate'>" + tag.getCreateDate() + "</div>" + 
            
            "<div class='f-left tag-disable'>" + 
                "<a href='tag/delete?id=" + tag.getId() + "'>" + 
                    "<input type='button' class='btn btn-min btn-normal' value='Disable'>" + 
                "</a>" +
            "</div>" + 
                
            "<div class='f-left tag-update'>" + 
                "<a href='tag/toupdate?id=" + tag.getId() + "'>" + 
                    "<input type='button' class='btn btn-min btn-normal' value='Update'>" + 
                "</a>" +
            "</div>" + 
            
            "<div class='f-left tag-add'>" + 
                "<a href='tag/toadd?parentTagId=" + tag.getId() + "'>" + 
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
