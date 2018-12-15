package com.example.user.project_name.path;

import android.content.Context;
import android.content.res.XmlResourceParser;

import java.util.ArrayList;
import java.util.List;

public class XMLModel {
    private XmlResourceParser xML;
    private List<XMLTagModel> tagList;

    public XMLModel(){
        this.tagList = new ArrayList<>();
    }

    public void setxML(String name, Context context) {
        this.xML = context.getResources().getXml(context.getResources().getIdentifier(name, "xml", context.getPackageName()));
    }

    public XmlResourceParser getxML() {
        return xML;
    }

    public List<XMLTagModel> getTagList() {
        return tagList;
    }
}
