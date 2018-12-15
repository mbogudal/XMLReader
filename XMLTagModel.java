package com.example.user.project_name.path;

import java.util.ArrayList;
import java.util.List;

public class XMLTagModel {
    private String tag;
    private String value;
    private List <XMLTagModel> childs;

    public XMLTagModel(){
        this.childs = new ArrayList<>();
        this.tag = null;
        this.value = null;
    }

    public void setTag(String tag){
        this.tag = tag;
    }

    public void setValue(String value){
        this.value = value;
    }

    public void addChild(XMLTagModel child){
        this.childs.add(child);
    }

    public String getTag(){
        return this.tag;
    }

    public String getValue(){
        return this.value;
    }

    public List <XMLTagModel> getChilds(){
        return this.childs;
    }

}
