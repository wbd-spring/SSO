Utils = {
	// 字符串去左右空格
	trim : function(str) {
		return str.replace(/(^\s+)|(\s+$)/g, "");
	},

	// 获取cookie值的方法
	getCookie : function(name) {

		var cookieItem, cookieName, cookieValue, // 临时变量
			tmp = document.cookie.split(";");
		for (var i = 0, len = tmp.length; i < len; ++i) {
			cookieItem = tmp[i].split("=");
			cookieName = Utils.trim(cookieItem[0]);
			cookieValue = cookieItem[1];

			if (name === cookieName) {
				return cookieValue;
			}
		}
	}
}
