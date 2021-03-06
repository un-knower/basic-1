{ 
  "total": "${block.page.totalpage}", 
  "page": "${block.page.currentpage}", 
  "records": "${block.page.totalnum}",
  "rows" : [
 [#list block.resultList as result]
 {"cell" :[		
 		[#assign yt="${result.use_desgin!''}"]
	    [#if EnumService.getEnum('sjyt')?exists]
	    [#list EnumService.getEnum('sjyt') as enum]
			[#if "${result.use_desgin!''}"=="${enum.enum_value!''}"]
				[#assign yt="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign jg="${result.build_struct!''}"]
	    [#if EnumService.getEnum('fwjg')?exists]
	    [#list EnumService.getEnum('fwjg') as enum]
			[#if "${result.build_struct!''}"=="${enum.enum_value!''}"]
				[#assign jg="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
		[#assign plx="${result.survey_type!''}"]
	    [#if EnumService.getEnum('survey_type')?exists]
	    [#list EnumService.getEnum('survey_type') as enum]
			[#if "${result.survey_type!''}"=="${enum.enum_value!''}"]
				[#assign plx="${enum.enum_name!''}"]
			[/#if]
		[/#list]
		[/#if]
	    [#assign manage_type=""]
	    [#if "${result.manage_type!''}"=="1"][#assign manage_type="物业管理"][/#if]
	    [#if "${result.manage_type!''}"=="2"][#assign manage_type="单位自管"][/#if]
	    [#if "${result.manage_type!''}"=="3"][#assign manage_type="无明确管理单位"][/#if]
	    [#if "${result.manage_type!''}"=="4"][#assign manage_type="其他"][/#if]
	    [#assign building_properties=""]
	    [#if "${result.building_properties!''}"=="1"][#assign building_properties="单位自管房"][/#if]
	    [#if "${result.building_properties!''}"=="2"][#assign building_properties="直管公房"][/#if]
	    [#if "${result.building_properties!''}"=="3"][#assign building_properties="房改住房"][/#if]
	    [#if "${result.building_properties!''}"=="4"][#assign building_properties="私房"][/#if]
	    [#if "${result.building_properties!''}"=="5"][#assign building_properties="其他"][/#if]
	    [#assign building_safecondition=""]
	    [#if "${result.building_safecondition!''}"=="1"][#assign building_safecondition="无问题房屋"][/#if]
	    [#if "${result.building_safecondition!''}"=="4"][#assign building_safecondition="有问题房屋"][/#if]
	    [#assign info_state=""]
	    [#if "${result.info_state!''}"=="0"][#assign info_state="暂存"][/#if]
	    [#if "${result.info_state!''}"=="1"][#assign info_state="未审核"][/#if]
	    [#if "${result.info_state!''}"=="2"][#assign info_state="审核驳回"][/#if]
	    [#if "${result.info_state!''}"=="8"][#assign info_state="审核通过"][/#if]
				
				"${result.building_id!''}"
				,"${result.survey_id!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.survey.detail?building_id=${result.building_id!''}&&survey_id=${result.survey_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>${result.building_newaddress!''}</a>"
				,"${result.building_address!''}"
				,"${yt!''}"
				,"${result.building_date!''}"
				,"${jg!''}"
				,"${manage_type!''}"
				,"${building_properties!''}"
				,"${building_safecondition!''}"
				,"${plx!''}"
				,[#if result.survey_date?exists]"${result.survey_date?string("yyyy-MM-dd")}"[#else]" "[/#if]
				,"${info_state!''}"		
				,"${result.last_editor!''}"
				,"<a href='javascript:void(0);' onclick=showModalDialog('${_servlet_url!''}/safecheck.buildingmapidenty?building_mapid=${result.building_id!''}','','dialogWidth:1000px;dialogHeight:600px;center:1;')>定位</a>"			
 			]}
 [#if result_has_next],[/#if]
 [/#list]
  ]
}