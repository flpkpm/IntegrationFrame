package com.epaylinks.myfirstframe;

import android.content.res.Resources;
import android.util.Log;

import com.epaylinks.myfirstframe.base.BaseApplication;

import java.util.HashMap;
import java.util.Map;

public class ErrCodeUtilsMap {
	private static Map<String, Integer> codeMap = new HashMap<String, Integer>();
	static {
		Log.d("deken","static "+codeMap.size());
		codeMap.put("30030", R.string.middle_30030);
		codeMap.put("30031", R.string.middle_30031);
		codeMap.put("30032", R.string.middle_30032);
		codeMap.put("30033", R.string.middle_30033);
		codeMap.put("30034", R.string.middle_30034);
		codeMap.put("30035", R.string.middle_30035);
		codeMap.put("30036", R.string.middle_30036);
		codeMap.put("30037", R.string.middle_30037);
		codeMap.put("30038", R.string.middle_30038);
		codeMap.put("30039", R.string.middle_30039);
		Log.d("deken","static "+codeMap.size());
	}

	public static String showMsg(String errCode) {
		Log.d("deken","showMsg ");
		Resources res = BaseApplication.mAppContext.getResources();
		return codeMap.get(errCode) != null ? res.getString(codeMap.get(errCode)) : errCode;
	}

}