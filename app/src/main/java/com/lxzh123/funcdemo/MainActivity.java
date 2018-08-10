package com.lxzh123.funcdemo;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity{

    private final static String ACTIVITYTAG="Activity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

        final String[] activityNames=getAllActivity();
        int len=activityNames.length;
        final String[] showNames=new String[len];
        for(int i=0;i<len;i++){
            String name=activityNames[i];
            showNames[i]=name.substring(name.lastIndexOf(".")+1).replace(ACTIVITYTAG,"");
        }

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.main,showNames);
        this.setListAdapter(adapter);
        this.getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                String className=activityNames[position];
                try{
                    Class clazz=Class.forName(className);
                    intent.setClass(MainActivity.this,clazz);
                }catch (Exception ex){
                    ex.printStackTrace();
                    return;
                }
                startActivity(intent);
            }
        });
	}

	private String[] getAllActivity(){
	    List<String> classNameList=new ArrayList<String>();
	    try{
            PackageInfo packageInfo=this.getPackageManager().getPackageInfo(this.getPackageName(), PackageManager.GET_ACTIVITIES);
            for(ActivityInfo ai:packageInfo.activities){
                String name=ai.name;
                if (name.endsWith(ACTIVITYTAG)&&!name.contains("Main")) {
                        classNameList.add(name);
                }
            }
//            DexFile df=new DexFile(this.getPackageCodePath());
//            Enumeration<String> enumeration = df.entries();//获取df中的元素  这里包含了所有可执行的类名 该类名包含了包名+类名的方式
//            while (enumeration.hasMoreElements()) {//遍历
//                String className = (String) enumeration.nextElement();
//
//                if (className.endsWith(ACTIVITYTAG)&&!className.contains("Main")) {//在当前所有可执行的类里面查找包含有该包名的所有类
//                    classNameList.add(className);
//                }
//            }
        }catch (Exception ex){

        }
        String[] rst=new String[classNameList.size()];
        return classNameList.toArray(rst);
    }
}
