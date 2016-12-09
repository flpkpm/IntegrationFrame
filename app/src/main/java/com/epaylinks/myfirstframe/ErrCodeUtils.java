package com.epaylinks.myfirstframe;

import android.content.res.Resources;

import com.epaylinks.myfirstframe.base.BaseApplication;

public class ErrCodeUtils {
	public static final int MIDDLE_ERR_30030=30030;
	public static final int MIDDLE_ERR_30031=30031;
	public static final int MIDDLE_ERR_30032=30032;
	public static final int MIDDLE_ERR_30033=30033;
	public static final int MIDDLE_ERR_30034=30034;
	public static final int MIDDLE_ERR_30035=30035;
	public static final int MIDDLE_ERR_30036=30036;
	public static final int MIDDLE_ERR_30037=30037;
	public static final int MIDDLE_ERR_30038=30038;
	public static final int MIDDLE_ERR_30039=30039;
	
	public static String showMsg(String errCode){
		String msg="";
		int code=Integer.parseInt(errCode);
		Resources res= BaseApplication.mAppContext.getResources();
		switch (code) {
		case MIDDLE_ERR_30030:
			msg=res.getString(R.string.middle_30030);
			break;
		case MIDDLE_ERR_30031:
			msg=res.getString(R.string.middle_30031);
			break;
		case MIDDLE_ERR_30032:
			msg=res.getString(R.string.middle_30032);
			break;
		case MIDDLE_ERR_30033:
			msg=res.getString(R.string.middle_30033);
			break;
		case MIDDLE_ERR_30034:
			msg=res.getString(R.string.middle_30034);
			break;
		case MIDDLE_ERR_30035:
			msg=res.getString(R.string.middle_30035);
			break;
		case MIDDLE_ERR_30036:
			msg=res.getString(R.string.middle_30036);
			break;
		case MIDDLE_ERR_30037:
			msg=res.getString(R.string.middle_30037);
			break;
		case MIDDLE_ERR_30038:
			msg=res.getString(R.string.middle_30038);
			break;
		case MIDDLE_ERR_30039:
			msg=res.getString(R.string.middle_30039);
			break;
		default:
			msg=errCode;
			break;
		
		}
		return msg;
	}
	
	
}
