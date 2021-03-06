package com.originsys.realtygis.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.originsys.eap.action.BaseAction;
import com.originsys.eap.domain.DataAndView;
import com.originsys.eap.iservice.IGet;
import com.originsys.eap.util.DataSource;
import com.originsys.eap.util.RequestAction;
import com.originsys.realtygis.domain.BuildingStructure;
import com.originsys.realtygis.domain.HouseHeightRange;

public class HouseThemeByExtent extends BaseAction implements IGet {
	public DataAndView execute(RequestAction arg0) throws Exception {
		// TODO Auto-generated method stub
		String parmas=arg0.getParameter("programes");
		String[] pararr=arg0.getParameterValues("info[]");
		
		Map<String, Object> map=new HashMap<String,Object>();
		BuildingStructure bust=new BuildingStructure();	
		List<HouseHeightRange> househeight=null;
		String sqlacrion=null;
		
		try {
		if("buildarea".equals(parmas)){
			sqlacrion = "Realtygis.extenthouseheight";
		}
		if("builddata".equals(parmas)){
			sqlacrion="Realtygis.extentbuildingdatacount";
		}
        if("buildstructure".equals(parmas)){
        	bust.setSteel("钢");
        	bust.setMixedsteel("钢混");
        	bust.setSteelconcrete("砼");
        	bust.setMixed("混");
        	bust.setBrick("砖");
        	bust.setBrickwood("砖木");
        	bust.setOther("其");     	
        	sqlacrion="Realtygis.extentbuildingstructurecount";
		}
		
		
		List<String> arrlist = Arrays.asList(pararr);
		List extent0=null;
		List extent1=null;
		List extent2=null;
		List extent3=null;
		List extent4=null;
		List extent5=null;
		List extent6=null;
		List extent7=null;
		List extent8=null;
		List extent9=null;
		
		int i = 0;
		if(arrlist.size()>1000){
			extent1=new ArrayList();
			extent1=arrlist.subList(0, 1000);
			i=1;
		}
		if(arrlist.size()>2000){
			extent2=new ArrayList();
			extent2=arrlist.subList(1000, 2000);
			i=2;
		}
		if(arrlist.size()>3000){
			extent3=new ArrayList(); 
			extent3=arrlist.subList(2000, 3000);
			i=3;
		}
		if(arrlist.size()>4000){
			extent4=new ArrayList();
			extent4=arrlist.subList(3000, 4000);
			i=4;
		}
		if(arrlist.size()>5000){
			extent5= new ArrayList();
			extent5=arrlist.subList(4000, 5000);
			i=5;
		}
		if(arrlist.size()>6000){
			extent6=new ArrayList();
			extent6=arrlist.subList(5000, 6000);
			i=6;
		}
		if(arrlist.size()>7000){
			extent7=new ArrayList();
			extent7=arrlist.subList(6000, 7000);
			i=7;
		}
		if(arrlist.size()>8000){
			extent8=new ArrayList();
			extent8=arrlist.subList(7000, 8000);
			i=8;
		}
		if(arrlist.size()>9000){
			extent9=new ArrayList();
			extent9=arrlist.subList(8000, 9000);
			i=9;
		}
		extent0=new ArrayList();
		extent0=arrlist.subList( i*1000, arrlist.size());
		SqlMapClient sc=DataSource.getSqlMapInstance();//定义一个操作数据库的ibatis接口变量
		//HouseHeightRange range=new HouseHeightRange();//定义一个量存储结果
		//Map<String, Object> map=new HashMap<String,Object>();
		//String sqlacrion=null;
		//BuildingStructure bust=new BuildingStructure();	
		bust.setExtent0(extent0);
		bust.setExtent1(extent1);
		bust.setExtent2(extent2);
		bust.setExtent3(extent3);
		bust.setExtent4(extent4);
		bust.setExtent5(extent5);
		bust.setExtent6(extent6);
		bust.setExtent7(extent7);
		bust.setExtent8(extent8);
		bust.setExtent9(extent9);
		
		//List<HouseHeightRange> househeight=(List)sc.queryForList(sqlacrion,bust);
        househeight=(List)sc.queryForList(sqlacrion,bust);
		if(!"buildarea".equals(parmas) && !"builddata".equals(parmas)){
			if("buildtype".equals(parmas)){
				//A test2 = (A) list.get(0)
				HouseHeightRange house0=(HouseHeightRange) househeight.get(0);
				HouseHeightRange house1=(HouseHeightRange) househeight.get(1);
				HouseHeightRange house2=(HouseHeightRange) househeight.get(2);
				HouseHeightRange house3=(HouseHeightRange) househeight.get(3);
				house0.range_name ="平房";
				house1.range_name ="多层";
				house2.range_name ="小高层";
				house3.range_name ="高层";
			}
	        if("buildstructure".equals(parmas)){
	        	HouseHeightRange house0=(HouseHeightRange) househeight.get(0);
				HouseHeightRange house1=(HouseHeightRange) househeight.get(1);
				HouseHeightRange house2=(HouseHeightRange) househeight.get(2);
				HouseHeightRange house3=(HouseHeightRange) househeight.get(3);
				HouseHeightRange house4=(HouseHeightRange) househeight.get(4);
				HouseHeightRange house5=(HouseHeightRange) househeight.get(5);
				HouseHeightRange house6=(HouseHeightRange) househeight.get(6);
				house0.range_name ="钢结构";
				house1.range_name ="钢、钢混结构";
				house2.range_name ="钢砼结构";
				house3.range_name ="混合结构";
				house4.range_name ="砖木结构";
				house5.range_name ="木结构";
				house6.range_name ="其他结构";
			}
		}		
		map.put("houselist",househeight);
	    map.put("range", bust);
		} catch (Exception e) {
			househeight = new ArrayList<HouseHeightRange>();
			if("buildarea".equals(parmas)){
				HouseHeightRange house0 = new HouseHeightRange();
				HouseHeightRange house1 = new HouseHeightRange();
				HouseHeightRange house2 = new HouseHeightRange();
				HouseHeightRange house3 = new HouseHeightRange();
				HouseHeightRange house4 = new HouseHeightRange();
				HouseHeightRange house5 = new HouseHeightRange();
				house0.range_name ="100";
				house1.range_name ="100-1000";
				house2.range_name ="1000-10000";
				house3.range_name ="10000-100000";
				house4.range_name ="100000-200000";
				house5.range_name ="200000";
				househeight.add(house0);
				househeight.add(house1);
				househeight.add(house2);
				househeight.add(house3);
				househeight.add(house4);
				househeight.add(house5);
			}
			if("builddata".equals(parmas)){
				HouseHeightRange house0 = new HouseHeightRange();
				HouseHeightRange house1 = new HouseHeightRange();
				HouseHeightRange house2 = new HouseHeightRange();
				HouseHeightRange house3 = new HouseHeightRange();
				house0.range_name ="1949";
				house1.range_name ="1949-1989";
				house2.range_name ="1989-2009";
				house3.range_name ="2009";
				househeight.add(house0);
				househeight.add(house1);
				househeight.add(house2);
				househeight.add(house3);
			}
	        if("buildstructure".equals(parmas)){
				HouseHeightRange house0 = new HouseHeightRange();
				HouseHeightRange house1 = new HouseHeightRange();
				HouseHeightRange house2 = new HouseHeightRange();
				HouseHeightRange house3 = new HouseHeightRange();
				HouseHeightRange house4 = new HouseHeightRange();
				HouseHeightRange house5 = new HouseHeightRange();
				HouseHeightRange house6 = new HouseHeightRange();
				house0.range_name ="钢结构";
				house1.range_name ="钢、钢混结构";
				house2.range_name ="钢砼结构";
				house3.range_name ="混合结构";
				house4.range_name ="砖木结构";
				house5.range_name ="木结构";
				house6.range_name ="其他结构";
				househeight.add(house0);
				househeight.add(house1);
				househeight.add(house2);
				househeight.add(house3);
				househeight.add(house4);
				househeight.add(house5);
				househeight.add(house6);
	        }
			
			map.put("houselist",househeight);
			map.put("range", bust);
		}
		return new DataAndView(map,"map");
	}
}
