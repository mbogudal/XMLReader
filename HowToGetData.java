/*
    For get data from XMLModel class you will need a xml structure.
*/

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TextView imageView1 = findViewById(R.id.textView);
        String text=" ";
        XMLModel xMLModel = new XMLModel(); // Create a model class
        xMLModel.setxML("xml", this); // Set name of file stored in xml path. Set context.
        XMLController xMLController = new XMLController(xMLModel); // Create controller
        xMLController.readXML(); // Read xml
        
        // Example loop for reading an xml
        
        for(int i = 0; i < xMLModel.getTagList().size(); i++){
            text+="\n";
            text += xMLModel.getTagList().get(i).getTag();
            text += ":";
            text += xMLModel.getTagList().get(i).getValue();
            text += "!";
            if(xMLModel.getTagList().get(i).getChilds().size() < 1) {
                text += xMLModel.getTagList().get(i).getTag();
                text += ":";
                text += xMLModel.getTagList().get(i).getValue();
                text += "!";
            }else{
                for (int i2 = 0; i2 < xMLModel.getTagList().get(i).getChilds().size(); i2++){
                    if(xMLModel.getTagList().get(i).getChilds().get(i2).getChilds().size()<1) {
                        text += "   " + xMLModel.getTagList().get(i).getChilds().get(i2).getTag();
                        text += ":";
                        text += xMLModel.getTagList().get(i).getChilds().get(i2).getValue();
                        text += "!";
                    }else {
                        for(int i3 =0; i3 < xMLModel.getTagList().get(i).getChilds().get(i2).getChilds().size(); i3++) {
                            text += "   " + xMLModel.getTagList().get(i).getChilds().get(i2).getChilds().get(i3).getTag();
                            text += ":";
                            text += xMLModel.getTagList().get(i).getChilds().get(i2).getChilds().get(i3).getValue();
                            text += "!";
                        }
                    }
                }
            }
        }

        imageView1.setText(text);
        
        
    }
}