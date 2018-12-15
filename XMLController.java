
//You must configure this for your'e project

package com.example.user.project_name.path;
import com.example.user.project_name.path.XMLModel;
import com.example.user.project_name.path.XMLTagModel;
import org.xmlpull.v1.XmlPullParserException;


import android.content.Context;
import android.content.res.XmlResourceParser;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class XMLController {

    private XMLModel xML;

    public XMLController(XMLModel xML){
        this.xML=xML;
    }

    public void readXML(){
        int eventType = -1;
        XMLTagModel tag = new XMLTagModel();
        while(eventType != XmlResourceParser.END_DOCUMENT)
        {
            try {
                eventType=this.xML.getxML().getEventType();
                //System.out.println(eventType);
                if (eventType == XmlResourceParser.START_TAG) {
                    this.tagName(tag);
                } else if(this.xML.getxML().getText() != null){
                    //System.out.println("step2");
                    tag.setValue(this.xML.getxML().getText());
                } else if(eventType == XmlResourceParser.END_TAG){
                    if(this.xML.getxML().getName()!=null && tag.getTag() == this.xML.getxML().getName()) {
                        //System.out.println("step3");
                        this.xML.getTagList().add(tag);
                        tag = new XMLTagModel();
                    }
                }

                this.xML.getxML().next();   /// moving to the next node
            } catch (XmlPullParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void readXML(XMLTagModel parrent){
        int eventType = -1;
        XMLTagModel tag = new XMLTagModel();
        while(eventType != XmlResourceParser.END_DOCUMENT)
        {
            try {
                eventType=this.xML.getxML().getEventType();
                if (eventType == XmlResourceParser.START_TAG) {
                    this.tagName(tag);
                } else if(this.xML.getxML().getText() != null){
                    //System.out.println("step2b");
                    tag.setValue(this.xML.getxML().getText());
                } else if(eventType == XmlResourceParser.END_TAG){
                    if(this.xML.getxML().getName()!=null && tag.getTag() == this.xML.getxML().getName()) {
                        //System.out.println("step3b");
                        parrent.addChild(tag);
                        return;
                    }
                }

                this.xML.getxML().next();   /// moving to the next node
            } catch (XmlPullParserException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void tagName(XMLTagModel tag){
        if(this.xML.getxML().getName() != null){
            if(tag.getTag() != null){
                if(!tag.getTag().equals(this.xML.getxML().getName())) {
                    //System.out.println("step4: " + this.xML.getName() + " / " + tag.getTag() );
                    this.readXML(tag);
                }
            } else{
                //System.out.println("step1");
                tag.setTag(this.xML.getxML().getName()); //odczytuje nazwę xmla
            }
        }
    }

    public XMLModel getxML() {
        return this.xML;
    }
}
