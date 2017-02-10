package com.jihf.topnews.entity;

import java.util.List;

/**
 * Func：
 * Desc:
 * Author：jihf
 * Data：2017-02-08 11:19
 * Mail：jihaifeng@raiyi.com
 */
public class NewsEntity {

  /**
   * reason : 成功的返回
   * result : {"stat":"1","data":[{"uniquekey":"68ce9646bfd9faf0741c573e43e241cb","title":"早观世界 |
   * 敲励志！轮椅女孩勇敢追梦成模特，一波美照奉上~","date":"2017-02-08 10:51","category":"头条","author_name":"央广新闻","url":"http://mini
   * .eastday.com/mobile/170208105156129.html","thumbnail_pic_s":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_3_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_4_mwpm_03200403.jpeg"},
   * {"uniquekey":"522da8781bae5a2ad7a6a7a25eca9281","title":"美商务部：美国2016年贸易逆差中国占比47%","date":"2017-02-08 11:00",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208110051116.html",
   * "thumbnail_pic_s":"http://06.imgmini.eastday
   * .com/mobile/20170208/20170208110051_854d7bba1067127a6aacfa75d3cedf2d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://06.imgmini.eastday
   * .com/mobile/20170208/20170208110051_854d7bba1067127a6aacfa75d3cedf2d_2_mwpm_03200403.jpeg"},
   * {"uniquekey":"d51f84f9bbb9c8ecc7f8013a69a0bfec","title":"山西一仓库起火升\"蘑菇云\" 官方:金属镁燃烧所致","date":"2017-02-08 10:38",
   * "category":"头条","author_name":"重庆晨报上游新闻","url":"http://mini.eastday.com/mobile/170208103837125.html",
   * "thumbnail_pic_s":"http://06.imgmini.eastday
   * .com/mobile/20170208/20170208103837_e530eb1de92e6ce8e84f8c3c2ef4b7f7_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"b47a4db30110b2e85a9139bdc8d36bc7","title":"中国导弹预警作战体系尚未完善 预警卫星刚开始立项","date":"2017-02-08 10:30",
   * "category":"头条","author_name":"新浪军事","url":"http://mini.eastday.com/mobile/170208103010588.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208103010_b4ebc0a04f0618f0ba9f733800eefb9d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208103010_b4ebc0a04f0618f0ba9f733800eefb9d_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208103010_b4ebc0a04f0618f0ba9f733800eefb9d_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"4304da60ae28f58ae2edf9a3cac65ef6","title":"与特朗普牵手感觉如何？传英国首相调侃对方\u201c手小\u201d","date":"2017-02-08
   * 10:18","category":"头条","author_name":"中国日报网","url":"http://mini.eastday.com/mobile/170208101847067.html",
   * "thumbnail_pic_s":"http://03.imgmini.eastday
   * .com/mobile/20170208/20170208101847_f79a1e1c8ba4aa3ba089c5b068457a27_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"75e1c15d6dab2f2a99d0fc3aec9b5e9c","title":"苹果新专利：耳机具有双模式 可进行自由切换","date":"2017-02-08 10:13",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208101356178.html",
   * "thumbnail_pic_s":"http://03.imgmini.eastday
   * .com/mobile/20170208/20170208101356_8e6727364bee130c4b245b4909c64963_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"d38c2d172dcda43cdbeda0586c3c019f","title":"中国是否已统治海洋？港媒称美战舰总吨位是中国5倍","date":"2017-02-08 10:13",
   * "category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/170208101347703.html",
   * "thumbnail_pic_s":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208101347_719473f5100ad10be3d3e4393057d57d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208101347_719473f5100ad10be3d3e4393057d57d_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208101347_719473f5100ad10be3d3e4393057d57d_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"7be7f247bdf948e45ef23c8aaae3d1e9","title":"欧弟女儿长这么大了？高马尾长刘海漂亮","date":"2017-02-08 10:13",
   * "category":"头条","author_name":"新浪娱乐","url":"http://mini.eastday.com/mobile/170208101346431.html",
   * "thumbnail_pic_s":"http://02.imgmini.eastday
   * .com/mobile/20170208/20170208101346_5197ad669fccf22e1e10c46deac21dc2_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"9002ad7379dd61b4c2a71f8480b1e138","title":"军委联合参谋部再添一将：邵元明履新副参谋长","date":"2017-02-08 10:00",
   * "category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170208100057797.html",
   * "thumbnail_pic_s":"http://07.imgmini.eastday
   * .com/mobile/20170208/20170208100057_847a230a89b92af75514c422c170c849_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"685fe38553f0799077e1679614074d44","title":"北京地区部队全面停止有偿服务，市长蔡奇任军地协调小组组长","date":"2017-02-08
   * 10:00","category":"头条","author_name":"北京日报","url":"http://mini.eastday.com/mobile/170208100057501.html",
   * "thumbnail_pic_s":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208100057_d7d0d73c30cd859782518c7f37986e92_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"03f51c4d92590d4222d4d23f52a653b2","title":"四川一镇自来水咖啡色两万人喝泥 投诉十年未果","date":"2017-02-08 09:57",
   * "category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170208095735650.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208095735_c9d1b9ba70e7148e8d725e897ffc1324_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208095735_c9d1b9ba70e7148e8d725e897ffc1324_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208095735_c9d1b9ba70e7148e8d725e897ffc1324_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"6fd4cab21f3198b9e2d4fb119ad9c1b8","title":"沪指低开0.16% 盘初板块个股普遍回落","date":"2017-02-08 09:54",
   * "category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170208095412552.html",
   * "thumbnail_pic_s":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208095412_2c2459de5319d7cada0cc03d0a2488c8_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"daed33a61b54dca35e83b9fd7027073a","title":"反华更反美！APA酒店老板被曝历史观上更加敌视美国","date":"2017-02-08 09:47",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208094752211.html",
   * "thumbnail_pic_s":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208094752_fa664a54e1aa35a43381275a7bbf6ee4_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"e364f6ab8f69038c2281d7d1ffb0c306","title":"不信任！韩前高官：我们或成为美国\u201c杀鸡儆猴\u201d的对象！",
   * "date":"2017-02-08 09:47","category":"头条","author_name":"环球网","url":"http://mini.eastday
   * .com/mobile/170208094751936.html","thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208094751_e2e4a056b3a35599a791a45356e0c546_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"1adb529b2761b2bad3281665cf32d903","title":"火箭军新导弹新春亮相 \u201c冲绳快递\u201d到底有多厉害？","date":"2017-02-08
   * 09:45","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170208094509202.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094509_ca8ec94d592b71d7b8d71870d9f83692_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094509_ca8ec94d592b71d7b8d71870d9f83692_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094509_ca8ec94d592b71d7b8d71870d9f83692_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"ff62bd1ad00a3a9bb6d56073cc76724e","title":"中央气象台专家解析本轮寒潮天气范围及影响","date":"2017-02-08 09:43",
   * "category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/170208094306407.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094306_0b72fae28cafab8caa47fac1fed52f0d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094306_0b72fae28cafab8caa47fac1fed52f0d_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094306_0b72fae28cafab8caa47fac1fed52f0d_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"ffba78205bb14489af8975a771a32eb5","title":"趁下班时间...阿富汗最高法院遭自杀炸弹袭 至少20死41伤","date":"2017-02-08
   * 09:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208093733391.html",
   * "thumbnail_pic_s":"http://03.imgmini.eastday
   * .com/mobile/20170208/20170208093733_cdb3370437c01bcb5f3b5a5068f85295_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"50372cd0d370e89dcf1a1edf51ea31d0","title":"曾狠甩谢霆锋老爸改嫁他人，4亿资产不给老公一分","date":"2017-02-08 09:36",
   * "category":"头条","author_name":"北青网","url":"http://mini.eastday.com/mobile/170208093646247.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208093646_f02f9543f5a9a62e887dce33e155e88a_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208093646_f02f9543f5a9a62e887dce33e155e88a_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208093646_f02f9543f5a9a62e887dce33e155e88a_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"a8bddbc64fddbf39dba3785ac0fcfaf1","title":"我今年114岁了，一位爱抽烟、喝酒的老寿星","date":"2017-02-08 09:33",
   * "category":"头条","author_name":"老衲法号福利","url":"http://mini.eastday.com/mobile/170208093303122.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208093303_b6ff3c4eb7c73074ecc99f83c54bc37e_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208093303_b6ff3c4eb7c73074ecc99f83c54bc37e_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208093303_b6ff3c4eb7c73074ecc99f83c54bc37e_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"357e4baec569dbc096650824ea4a2138","title":"伊朗最高精神领袖哈梅内伊：特朗普显露美国真实嘴脸","date":"2017-02-08 09:26",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208092641984.html",
   * "thumbnail_pic_s":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092641_941782b7893ea4b2786531bde02fa2aa_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"46562afa884ee2cbd99fb0dbdbaf723e","title":"体育基因、品质追求、全球视角\u2014\u20142022，蒙牛与中国同梦",
   * "date":"2017-02-08 09:26","category":"头条","author_name":"环球网","url":"http://mini.eastday
   * .com/mobile/170208092640778.html","thumbnail_pic_s":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092640_ff76f14d6bf9352eb9db355969e99545_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092640_ff76f14d6bf9352eb9db355969e99545_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092640_36a3bcf556ee4fb8981d0fbe064ea309_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"f8f88449b23d4b4d5a3f5fb9240ef22d","title":"LG发布G6邀请函：大屏无边是亮点","date":"2017-02-08 09:16",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208091618899.html",
   * "thumbnail_pic_s":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208091618_ae1f7edc0769cace82513d63dcdb2146_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"f5302e57d1f81ba724637e5b5818592d","title":"无官一身轻：奥巴马在加勒比海悠闲度假 学玩冲浪","date":"2017-02-08 09:13",
   * "category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170208091350801.html",
   * "thumbnail_pic_s":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208091350_a0b3daa5692e8d0491f6565830f74d85_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"36660781fa443721a52b83d190be4939","title":"美专家：弃\u201c一中\u201d极其危险 中美或\u201c撞车\u201d",
   * "date":"2017-02-08 09:00","category":"头条","author_name":"环球网","url":"http://mini.eastday
   * .com/mobile/170208090024544.html","thumbnail_pic_s":"http://07.imgmini.eastday
   * .com/mobile/20170208/20170208090024_830e590a24140d1d926cf8764d399f05_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"b8b9b3fd9923da396d2cc518a1255ffb","title":"陕西省最富的几个县","date":"2017-02-08 08:54","category":"头条",
   * "author_name":"漂洋过海看阿三","url":"http://mini.eastday.com/mobile/170208085424286.html","thumbnail_pic_s":"http://00
   * .imgmini.eastday.com/mobile/20170208/20170208085424_1f14cd011c05472fa3d8eb8511d89e97_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208085424_1f14cd011c05472fa3d8eb8511d89e97_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208085424_1f14cd011c05472fa3d8eb8511d89e97_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"bc557e5cc03e3e9424f4a4e913ef6630","title":"中兴：2017年上半年拟在印度发行7款智能手机","date":"2017-02-08 08:49",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208084956999.html",
   * "thumbnail_pic_s":"http://02.imgmini.eastday
   * .com/mobile/20170208/20170208084956_278b5fd7f33a3fab832c0e25f6c9bf22_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"bacfdc072dec23ba2acce841218f60e7","title":"《中国诗词大会》武亦姝登顶 看她\u201c过关斩将\u201d","date":"2017-02-08
   * 08:48","category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170208084834871.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084834_6589363ddd3b790977d163ca4cc627e9_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"4d7668deb0942b0d5376c9a06044e072","title":"巴西警察罢工引骚乱 黑帮厮杀致75死","date":"2017-02-08 08:48",
   * "category":"头条","author_name":"环球网综合","url":"http://mini.eastday.com/mobile/170208084812092.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084812_432e2bad823571e26c76eb5339162b8c_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084812_c180e7667b4790797521e8d6d9d964da_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084812_b134f5323a596ad08ec35a21fece4344_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"2412f93be7b790e049e87bc96f3b72ef","title":"现实就是这么残酷，在2017年这五种养殖户将会被淘汰","date":"2017-02-08 08:45",
   * "category":"头条","author_name":"养殖保姆","url":"http://mini.eastday.com/mobile/170208084537848.html",
   * "thumbnail_pic_s":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208084537_c25cef35ed143763d3af23c5088ecaf3_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208084537_c25cef35ed143763d3af23c5088ecaf3_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208084537_c25cef35ed143763d3af23c5088ecaf3_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"dcb98cd040afcfbae699f2517949fce1","title":"美富翁不满拥堵交通 自修专用隧道直达公司","date":"2017-02-08 08:45",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208084524141.html",
   * "thumbnail_pic_s":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208084524_9e00c6ff4e6331e8b6d4de38e90563df_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208084524_9e00c6ff4e6331e8b6d4de38e90563df_2_mwpm_03200403.jpeg"}]}
   * error_code : 0
   */

  private String reason;
  /**
   * stat : 1
   * data : [{"uniquekey":"68ce9646bfd9faf0741c573e43e241cb","title":"早观世界 | 敲励志！轮椅女孩勇敢追梦成模特，一波美照奉上~",
   * "date":"2017-02-08 10:51","category":"头条","author_name":"央广新闻","url":"http://mini.eastday
   * .com/mobile/170208105156129.html","thumbnail_pic_s":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_3_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_4_mwpm_03200403.jpeg"},
   * {"uniquekey":"522da8781bae5a2ad7a6a7a25eca9281","title":"美商务部：美国2016年贸易逆差中国占比47%","date":"2017-02-08 11:00",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208110051116.html",
   * "thumbnail_pic_s":"http://06.imgmini.eastday
   * .com/mobile/20170208/20170208110051_854d7bba1067127a6aacfa75d3cedf2d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://06.imgmini.eastday
   * .com/mobile/20170208/20170208110051_854d7bba1067127a6aacfa75d3cedf2d_2_mwpm_03200403.jpeg"},
   * {"uniquekey":"d51f84f9bbb9c8ecc7f8013a69a0bfec","title":"山西一仓库起火升\"蘑菇云\" 官方:金属镁燃烧所致","date":"2017-02-08 10:38",
   * "category":"头条","author_name":"重庆晨报上游新闻","url":"http://mini.eastday.com/mobile/170208103837125.html",
   * "thumbnail_pic_s":"http://06.imgmini.eastday
   * .com/mobile/20170208/20170208103837_e530eb1de92e6ce8e84f8c3c2ef4b7f7_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"b47a4db30110b2e85a9139bdc8d36bc7","title":"中国导弹预警作战体系尚未完善 预警卫星刚开始立项","date":"2017-02-08 10:30",
   * "category":"头条","author_name":"新浪军事","url":"http://mini.eastday.com/mobile/170208103010588.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208103010_b4ebc0a04f0618f0ba9f733800eefb9d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208103010_b4ebc0a04f0618f0ba9f733800eefb9d_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208103010_b4ebc0a04f0618f0ba9f733800eefb9d_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"4304da60ae28f58ae2edf9a3cac65ef6","title":"与特朗普牵手感觉如何？传英国首相调侃对方\u201c手小\u201d","date":"2017-02-08
   * 10:18","category":"头条","author_name":"中国日报网","url":"http://mini.eastday.com/mobile/170208101847067.html",
   * "thumbnail_pic_s":"http://03.imgmini.eastday
   * .com/mobile/20170208/20170208101847_f79a1e1c8ba4aa3ba089c5b068457a27_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"75e1c15d6dab2f2a99d0fc3aec9b5e9c","title":"苹果新专利：耳机具有双模式 可进行自由切换","date":"2017-02-08 10:13",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208101356178.html",
   * "thumbnail_pic_s":"http://03.imgmini.eastday
   * .com/mobile/20170208/20170208101356_8e6727364bee130c4b245b4909c64963_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"d38c2d172dcda43cdbeda0586c3c019f","title":"中国是否已统治海洋？港媒称美战舰总吨位是中国5倍","date":"2017-02-08 10:13",
   * "category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/170208101347703.html",
   * "thumbnail_pic_s":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208101347_719473f5100ad10be3d3e4393057d57d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208101347_719473f5100ad10be3d3e4393057d57d_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208101347_719473f5100ad10be3d3e4393057d57d_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"7be7f247bdf948e45ef23c8aaae3d1e9","title":"欧弟女儿长这么大了？高马尾长刘海漂亮","date":"2017-02-08 10:13",
   * "category":"头条","author_name":"新浪娱乐","url":"http://mini.eastday.com/mobile/170208101346431.html",
   * "thumbnail_pic_s":"http://02.imgmini.eastday
   * .com/mobile/20170208/20170208101346_5197ad669fccf22e1e10c46deac21dc2_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"9002ad7379dd61b4c2a71f8480b1e138","title":"军委联合参谋部再添一将：邵元明履新副参谋长","date":"2017-02-08 10:00",
   * "category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170208100057797.html",
   * "thumbnail_pic_s":"http://07.imgmini.eastday
   * .com/mobile/20170208/20170208100057_847a230a89b92af75514c422c170c849_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"685fe38553f0799077e1679614074d44","title":"北京地区部队全面停止有偿服务，市长蔡奇任军地协调小组组长","date":"2017-02-08
   * 10:00","category":"头条","author_name":"北京日报","url":"http://mini.eastday.com/mobile/170208100057501.html",
   * "thumbnail_pic_s":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208100057_d7d0d73c30cd859782518c7f37986e92_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"03f51c4d92590d4222d4d23f52a653b2","title":"四川一镇自来水咖啡色两万人喝泥 投诉十年未果","date":"2017-02-08 09:57",
   * "category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170208095735650.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208095735_c9d1b9ba70e7148e8d725e897ffc1324_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208095735_c9d1b9ba70e7148e8d725e897ffc1324_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208095735_c9d1b9ba70e7148e8d725e897ffc1324_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"6fd4cab21f3198b9e2d4fb119ad9c1b8","title":"沪指低开0.16% 盘初板块个股普遍回落","date":"2017-02-08 09:54",
   * "category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170208095412552.html",
   * "thumbnail_pic_s":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208095412_2c2459de5319d7cada0cc03d0a2488c8_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"daed33a61b54dca35e83b9fd7027073a","title":"反华更反美！APA酒店老板被曝历史观上更加敌视美国","date":"2017-02-08 09:47",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208094752211.html",
   * "thumbnail_pic_s":"http://04.imgmini.eastday
   * .com/mobile/20170208/20170208094752_fa664a54e1aa35a43381275a7bbf6ee4_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"e364f6ab8f69038c2281d7d1ffb0c306","title":"不信任！韩前高官：我们或成为美国\u201c杀鸡儆猴\u201d的对象！",
   * "date":"2017-02-08 09:47","category":"头条","author_name":"环球网","url":"http://mini.eastday
   * .com/mobile/170208094751936.html","thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208094751_e2e4a056b3a35599a791a45356e0c546_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"1adb529b2761b2bad3281665cf32d903","title":"火箭军新导弹新春亮相 \u201c冲绳快递\u201d到底有多厉害？","date":"2017-02-08
   * 09:45","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170208094509202.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094509_ca8ec94d592b71d7b8d71870d9f83692_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094509_ca8ec94d592b71d7b8d71870d9f83692_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094509_ca8ec94d592b71d7b8d71870d9f83692_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"ff62bd1ad00a3a9bb6d56073cc76724e","title":"中央气象台专家解析本轮寒潮天气范围及影响","date":"2017-02-08 09:43",
   * "category":"头条","author_name":"新华网","url":"http://mini.eastday.com/mobile/170208094306407.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094306_0b72fae28cafab8caa47fac1fed52f0d_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094306_0b72fae28cafab8caa47fac1fed52f0d_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208094306_0b72fae28cafab8caa47fac1fed52f0d_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"ffba78205bb14489af8975a771a32eb5","title":"趁下班时间...阿富汗最高法院遭自杀炸弹袭 至少20死41伤","date":"2017-02-08
   * 09:37","category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208093733391.html",
   * "thumbnail_pic_s":"http://03.imgmini.eastday
   * .com/mobile/20170208/20170208093733_cdb3370437c01bcb5f3b5a5068f85295_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"50372cd0d370e89dcf1a1edf51ea31d0","title":"曾狠甩谢霆锋老爸改嫁他人，4亿资产不给老公一分","date":"2017-02-08 09:36",
   * "category":"头条","author_name":"北青网","url":"http://mini.eastday.com/mobile/170208093646247.html",
   * "thumbnail_pic_s":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208093646_f02f9543f5a9a62e887dce33e155e88a_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208093646_f02f9543f5a9a62e887dce33e155e88a_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://05.imgmini.eastday
   * .com/mobile/20170208/20170208093646_f02f9543f5a9a62e887dce33e155e88a_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"a8bddbc64fddbf39dba3785ac0fcfaf1","title":"我今年114岁了，一位爱抽烟、喝酒的老寿星","date":"2017-02-08 09:33",
   * "category":"头条","author_name":"老衲法号福利","url":"http://mini.eastday.com/mobile/170208093303122.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208093303_b6ff3c4eb7c73074ecc99f83c54bc37e_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208093303_b6ff3c4eb7c73074ecc99f83c54bc37e_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208093303_b6ff3c4eb7c73074ecc99f83c54bc37e_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"357e4baec569dbc096650824ea4a2138","title":"伊朗最高精神领袖哈梅内伊：特朗普显露美国真实嘴脸","date":"2017-02-08 09:26",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208092641984.html",
   * "thumbnail_pic_s":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092641_941782b7893ea4b2786531bde02fa2aa_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"46562afa884ee2cbd99fb0dbdbaf723e","title":"体育基因、品质追求、全球视角\u2014\u20142022，蒙牛与中国同梦",
   * "date":"2017-02-08 09:26","category":"头条","author_name":"环球网","url":"http://mini.eastday
   * .com/mobile/170208092640778.html","thumbnail_pic_s":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092640_ff76f14d6bf9352eb9db355969e99545_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092640_ff76f14d6bf9352eb9db355969e99545_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208092640_36a3bcf556ee4fb8981d0fbe064ea309_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"f8f88449b23d4b4d5a3f5fb9240ef22d","title":"LG发布G6邀请函：大屏无边是亮点","date":"2017-02-08 09:16",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208091618899.html",
   * "thumbnail_pic_s":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208091618_ae1f7edc0769cace82513d63dcdb2146_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"f5302e57d1f81ba724637e5b5818592d","title":"无官一身轻：奥巴马在加勒比海悠闲度假 学玩冲浪","date":"2017-02-08 09:13",
   * "category":"头条","author_name":"中国新闻网","url":"http://mini.eastday.com/mobile/170208091350801.html",
   * "thumbnail_pic_s":"http://09.imgmini.eastday
   * .com/mobile/20170208/20170208091350_a0b3daa5692e8d0491f6565830f74d85_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"36660781fa443721a52b83d190be4939","title":"美专家：弃\u201c一中\u201d极其危险 中美或\u201c撞车\u201d",
   * "date":"2017-02-08 09:00","category":"头条","author_name":"环球网","url":"http://mini.eastday
   * .com/mobile/170208090024544.html","thumbnail_pic_s":"http://07.imgmini.eastday
   * .com/mobile/20170208/20170208090024_830e590a24140d1d926cf8764d399f05_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"b8b9b3fd9923da396d2cc518a1255ffb","title":"陕西省最富的几个县","date":"2017-02-08 08:54","category":"头条",
   * "author_name":"漂洋过海看阿三","url":"http://mini.eastday.com/mobile/170208085424286.html","thumbnail_pic_s":"http://00
   * .imgmini.eastday.com/mobile/20170208/20170208085424_1f14cd011c05472fa3d8eb8511d89e97_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208085424_1f14cd011c05472fa3d8eb8511d89e97_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208085424_1f14cd011c05472fa3d8eb8511d89e97_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"bc557e5cc03e3e9424f4a4e913ef6630","title":"中兴：2017年上半年拟在印度发行7款智能手机","date":"2017-02-08 08:49",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208084956999.html",
   * "thumbnail_pic_s":"http://02.imgmini.eastday
   * .com/mobile/20170208/20170208084956_278b5fd7f33a3fab832c0e25f6c9bf22_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"bacfdc072dec23ba2acce841218f60e7","title":"《中国诗词大会》武亦姝登顶 看她\u201c过关斩将\u201d","date":"2017-02-08
   * 08:48","category":"头条","author_name":"澎湃新闻","url":"http://mini.eastday.com/mobile/170208084834871.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084834_6589363ddd3b790977d163ca4cc627e9_1_mwpm_03200403.jpeg"},
   * {"uniquekey":"4d7668deb0942b0d5376c9a06044e072","title":"巴西警察罢工引骚乱 黑帮厮杀致75死","date":"2017-02-08 08:48",
   * "category":"头条","author_name":"环球网综合","url":"http://mini.eastday.com/mobile/170208084812092.html",
   * "thumbnail_pic_s":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084812_432e2bad823571e26c76eb5339162b8c_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084812_c180e7667b4790797521e8d6d9d964da_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://01.imgmini.eastday
   * .com/mobile/20170208/20170208084812_b134f5323a596ad08ec35a21fece4344_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"2412f93be7b790e049e87bc96f3b72ef","title":"现实就是这么残酷，在2017年这五种养殖户将会被淘汰","date":"2017-02-08 08:45",
   * "category":"头条","author_name":"养殖保姆","url":"http://mini.eastday.com/mobile/170208084537848.html",
   * "thumbnail_pic_s":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208084537_c25cef35ed143763d3af23c5088ecaf3_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208084537_c25cef35ed143763d3af23c5088ecaf3_2_mwpm_03200403.jpeg",
   * "thumbnail_pic_s03":"http://08.imgmini.eastday
   * .com/mobile/20170208/20170208084537_c25cef35ed143763d3af23c5088ecaf3_3_mwpm_03200403.jpeg"},
   * {"uniquekey":"dcb98cd040afcfbae699f2517949fce1","title":"美富翁不满拥堵交通 自修专用隧道直达公司","date":"2017-02-08 08:45",
   * "category":"头条","author_name":"环球网","url":"http://mini.eastday.com/mobile/170208084524141.html",
   * "thumbnail_pic_s":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208084524_9e00c6ff4e6331e8b6d4de38e90563df_1_mwpm_03200403.jpeg",
   * "thumbnail_pic_s02":"http://00.imgmini.eastday
   * .com/mobile/20170208/20170208084524_9e00c6ff4e6331e8b6d4de38e90563df_2_mwpm_03200403.jpeg"}]
   */

  private ResultBean result;
  private int error_code;

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public ResultBean getResult() {
    return result;
  }

  public void setResult(ResultBean result) {
    this.result = result;
  }

  public int getError_code() {
    return error_code;
  }

  public void setError_code(int error_code) {
    this.error_code = error_code;
  }

  public static class ResultBean {
    private String stat;
    /**
     * uniquekey : 68ce9646bfd9faf0741c573e43e241cb
     * title : 早观世界 | 敲励志！轮椅女孩勇敢追梦成模特，一波美照奉上~
     * date : 2017-02-08 10:51
     * category : 头条
     * author_name : 央广新闻
     * url : http://mini.eastday.com/mobile/170208105156129.html
     * thumbnail_pic_s : http://04.imgmini.eastday
     * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_2_mwpm_03200403.jpeg
     * thumbnail_pic_s02 : http://04.imgmini.eastday
     * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_3_mwpm_03200403.jpeg
     * thumbnail_pic_s03 : http://04.imgmini.eastday
     * .com/mobile/20170208/20170208105156_b73273760cee4deea9a32fe59363e03b_4_mwpm_03200403.jpeg
     */

    private List<DataBean> data;

    public String getStat() {
      return stat;
    }

    public void setStat(String stat) {
      this.stat = stat;
    }

    public List<DataBean> getData() {
      return data;
    }

    public void setData(List<DataBean> data) {
      this.data = data;
    }

    public static class DataBean {
      private String uniquekey;
      private String title;
      private String date;
      private String category;
      private String author_name;
      private String url;
      private String thumbnail_pic_s;
      private String thumbnail_pic_s02;
      private String thumbnail_pic_s03;

      public String getUniquekey() {
        return uniquekey;
      }

      public void setUniquekey(String uniquekey) {
        this.uniquekey = uniquekey;
      }

      public String getTitle() {
        return title;
      }

      public void setTitle(String title) {
        this.title = title;
      }

      public String getDate() {
        return date;
      }

      public void setDate(String date) {
        this.date = date;
      }

      public String getCategory() {
        return category;
      }

      public void setCategory(String category) {
        this.category = category;
      }

      public String getAuthor_name() {
        return author_name;
      }

      public void setAuthor_name(String author_name) {
        this.author_name = author_name;
      }

      public String getUrl() {
        return url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
      }

      public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
      }

      public String getThumbnail_pic_s02() {
        return thumbnail_pic_s02;
      }

      public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
        this.thumbnail_pic_s02 = thumbnail_pic_s02;
      }

      public String getThumbnail_pic_s03() {
        return thumbnail_pic_s03;
      }

      public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
        this.thumbnail_pic_s03 = thumbnail_pic_s03;
      }
    }
  }
}
