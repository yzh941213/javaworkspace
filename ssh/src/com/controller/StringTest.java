package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import system.uitls.StringUtil;

import java.util.*;
import java.util.stream.Collectors;

public class StringTest {


    public static void main(String[] args) {

      String str = "北京(010)天津(022)邯郸(0310)石家庄(0311)" +
              "保定(0312)张家口(0313)承德(0314)唐山(0315)廊坊(0316)" +
              "沧州(0317)衡水(0318)邢台(0319)秦皇岛(0335)朔州(0349)忻州(0350)太原(0351)大同(0352)阳泉(0353)晋中(0354)长治(0355)晋城(0356)临汾(0357)吕梁(0358)运城(0359)呼伦贝尔(0470)呼和浩特(0471)包头(0472)乌海(0473)乌兰察布(0474)通辽(0475)赤峰(0476)鄂尔多斯(0477)巴彦淖尔(0478)锡林郭勒盟(0479)兴安盟(0482)阿拉善盟(0483)沈阳(024)铁岭(024)大连(0411)鞍山(0412)抚顺(024)本溪(0414)丹东(0415)锦州(0416)营口(0417)阜新(0418)辽阳(0419)朝阳(0421)盘锦(0427)葫芦岛(0429)长春(0431)吉林(0432)延边朝鲜族自治州(0433)四平(0434)通化(0435)白城(0436)辽源(0437)松原(0438)白山(0439)哈尔滨(0451)齐齐哈尔(0452)牡丹江(0453)佳木斯(0454)绥化(0455)黑河(0456)大兴安岭地区(0457)伊春(0458)大庆(0459)七台河(0464)鸡西(0467)鹤岗(0468)双鸭山(0469)上海市上海(021)南京(025)无锡(0510)镇江(0511)苏州(0512)南通(0513)扬州(0514)盐城(0515)徐州(0516)淮安(0517)连云港(0518)常州(0519)泰州(0523)宿迁(0527)衢州(0570)杭州(0571)湖州(0572)嘉兴(0573)宁波(0574)绍兴(0575)台州(0576)温州(0577)丽水(0578)金华(0579)舟山(0580)滁州(0550)合肥(0551)蚌埠(0552)芜湖(0553)淮南(0554)马鞍山(0555)安庆(0556)宿州(0557)亳州(0558)阜阳(0558)黄山(0559)淮北(0561)铜陵(0562)宣城(0563)六安(0564)巢湖(0565)池州(0566)福州(0591)厦门(0592)宁德(0593)莆田(0594)泉州(0595)漳州(0596)龙岩(0597)三明(0598)南平(0599)鹰潭(0701)新余(0790)南昌(0791)九江(0792)上饶(0793)抚州(0794)宜春(0795)吉安(0796)赣州(0797)景德镇(0798)萍乡(0799)菏泽(0530)济南(0531)青岛(0532)淄博(0533)德州(0534)烟台(0535)潍坊(0536)济宁(0537)泰安(0538)临沂(0539)滨州(0543)东营(0546)威海(0631)枣庄(0632)日照(0633)莱芜(0634)聊城(0635)商丘(0370)郑州(0371)安阳(0372)新乡(0373)许昌(0374)平顶山(0375)信阳(0376)南阳(0377)开封(0378)洛阳(0379)济源(0391)焦作(0391)鹤壁(0392)濮阳(0393)周口(0394)漯河(0395)驻马店(0396)三门峡(0398)直辖行政单位(027)武汉(027)襄樊(0710)鄂州(0711)孝感(0712)黄冈(0713)黄石(0714)咸宁(0715)荆州(0716)宜昌(0717)恩施土家族苗族自治州(0718)十堰(0719)随州(0722)荆门(0724)岳阳(0730)长沙(0731)湘潭(0731)株洲(0731)衡阳(0734)郴州(0735)常德(0736)益阳(0737)娄底(0738)邵阳(0739)湘西土家族苗族自治州(0743)张家界(0744)怀化(0745)永州(0746)广州(020)汕尾(0660)阳江(0662)揭阳(0663)茂名(0668)江门(0750)韶关(0751)惠州(0752)梅州(0753)汕头(0754)深圳(0755)珠海(0756)佛山(0757)肇庆(0758)湛江(0759)中山(0760)河源(0762)清远(0763)云浮(0766)潮州(0768)东莞(0769)防城港(0770)崇左(0771)南宁(0771)来宾(0772)柳州(0772)桂林(0773)贺州(0774)梧州(0774)贵港(0775)玉林(0775)百色(0776)钦州(0777)河池(0778)北海(0779)海口(0898)三亚(0898)重庆市重庆(023)成都(028)攀枝花(0812)自贡(0813)绵阳(0816)南充(0817)达州(0818)遂宁(0825)广安(0826)巴中(0827)泸州(0830)宜宾(0831)内江(0832)资阳(028)乐山(0833)眉山(028)凉山彝族自治州(0834)雅安(0835)甘孜藏族自治州(0836)阿坝藏族羌族自治州(0837)德阳(0838)广元(0839)贵阳(0851)遵义(0852)安顺(0853)黔南布依族苗族自治州(0854)黔东南苗族侗族自治州(0855)铜仁地区(0856)毕节地区(0857)六盘水(0858)黔西南布依族苗族自治州(0859)西双版纳傣族自治州(0691)德宏傣族景颇族自治州(0692)昭通(0870)昆明(0871)大理白族自治州(0872)红河哈尼族彝族自治州(0873)曲靖(0874)保山(0875)文山壮族苗族自治州(0876)玉溪(0877)楚雄彝族自治州(0878)思茅(0879)临沧(0883)怒江傈僳族自治州(0886)迪庆藏族自治州(0887)丽江(0888)拉萨(0891)日喀则地区(0892)山南地区(0893)林芝地区(0894)昌都地区(0895)那曲地区(0896)阿里地区(0897)西安(029)咸阳(029)延安(0911)榆林(0912)渭南(0913)商洛(0914)安康(0915)汉中(0916)宝鸡(0917)铜川(0919)临夏回族自治州(0930)兰州(0931)定西(0932)平凉(0933)庆阳(0934)金昌(0935)武威(0935)张掖(0936)嘉峪关(0937)酒泉(0937)天水(0938)陇南(0939)甘南藏族自治州(0941)白银(0943)海北藏族自治州(0970)西宁(0971)海东地区(0972)黄南藏族自治州(0973)海南藏族自治州(0974)果洛藏族自治州(0975)玉树藏族自治州(0976)海西蒙古族藏族自治州(0979)银川(0951)石嘴山(0952)吴忠(0953)固原(0954)中卫(0955)直辖行政单位(0901)哈密地区(0902)和田地区(0903)阿勒泰地区(0906)克孜勒苏柯尔克孜自治州(0908)博尔塔拉蒙古自治州(0909)克拉玛依(0990)乌鲁木齐(0991)昌吉回族自治州(0994)吐鲁番地区(0995)巴音郭楞蒙古自治州(0996)阿克苏地区(0997)喀什地区(0998)伊犁哈萨克自治州(0999)基隆市(8862)台北市(8862)台北县(8862)花莲县(8863)桃园县(8863)新竹县(8863)宜兰县(8863)苗栗县(88637)台中市(8864)台中市(8864)彰化县(8864)南投县(88649)嘉义县(8865)云林县(8865)澎湖县(8866)台南市(8866)台南县(8866)高雄县(8867)屏东县(8868)台东县(88689)";

        char[] str2 = str
                .replaceAll("\n","")
                .replaceAll("\t","")
                .replaceAll(" ","")
                .replaceAll("\\(","")
                .replaceAll("\\)","")
                .toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean b = false;
        for (int i=0;i<str2.length;i++){
            if (str2[i]<='9'&&str2[i]>='0'){
                if (!b)sb.append("-");
                sb.append(str2[i]);
                b = true;
            }else {
                if (b){
                    if (StringUtil.isNotEmpty(sb))sb.append(",");
                    b = false;
                }
                sb.append(str2[i]);
            }
        }
        String[]strs = sb.toString().split(",");
        List<Map>mapList = new ArrayList<>();
        for (String s:strs){
            Map<String,Object>map = new HashMap<>();
            map.put("zone",s.split("-")[0]);
            map.put("code",s.split("-")[1]);
            //s.split("-");
            mapList.add(map);
        }
        System.out.println(new Gson().toJson(mapList));

        //System.out.println(JSONObject.parseArray("[{\"code\":\"010\",\"zone\":\"北京市\"},{\"code\":\"021\",\"zone\":\"上海市\"},{\"code\":\"022\",\"zone\":\"天津市\"},{\"code\":\"023\",\"zone\":\"重庆市\"},{\"code\":\"852\",\"zone\":\"香港\"},{\"code\":\"853\",\"zone\":\"澳门\"},{\"code\":\"0310\",\"zone\":\"邯郸市\"},{\"code\":\"0311\",\"zone\":\"石家庄\"},{\"code\":\"0312\",\"zone\":\"保定市\"},{\"code\":\"0313\",\"zone\":\"张家口\"},{\"code\":\"0314\",\"zone\":\"承德市\"},{\"code\":\"0315\",\"zone\":\"唐山市\"},{\"code\":\"0316\",\"zone\":\"廊坊市\"},{\"code\":\"0317\",\"zone\":\"沧州市\"},{\"code\":\"0318\",\"zone\":\"衡水市\"},{\"code\":\"0319\",\"zone\":\"邢台市\"},{\"code\":\"0335\",\"zone\":\"秦皇岛\"},{\"code\":\"0570\",\"zone\":\"衢州市\"},{\"code\":\"0571\",\"zone\":\"杭州市\"},{\"code\":\"0572\",\"zone\":\"湖州市\"},{\"code\":\"0573\",\"zone\":\"嘉兴市\"},{\"code\":\"0574\",\"zone\":\"宁波市\"},{\"code\":\"0575\",\"zone\":\"绍兴市\"},{\"code\":\"0576\",\"zone\":\"台州市\"},{\"code\":\"0577\",\"zone\":\"温州市\"},{\"code\":\"0578\",\"zone\":\"丽水市\"},{\"code\":\"0579\",\"zone\":\"金华市\"},{\"code\":\"0580\",\"zone\":\"舟山市\"},{\"code\":\"024\",\"zone\":\"沈阳市\"},{\"code\":\"0410\",\"zone\":\"铁岭市\"},{\"code\":\"0411\",\"zone\":\"大连市\"},{\"code\":\"0412\",\"zone\":\"鞍山市\"},{\"code\":\"0413\",\"zone\":\"抚顺市\"},{\"code\":\"0414\",\"zone\":\"本溪市\"},{\"code\":\"0415\",\"zone\":\"丹东市\"},{\"code\":\"0416\",\"zone\":\"锦州市\"},{\"code\":\"0417\",\"zone\":\"营口市\"},{\"code\":\"0418\",\"zone\":\"阜新市\"},{\"code\":\"0419\",\"zone\":\"辽阳市\"},{\"code\":\"0421\",\"zone\":\"朝阳市\"},{\"code\":\"0427\",\"zone\":\"盘锦市\"},{\"code\":\"0429\",\"zone\":\"葫芦岛\"},{\"code\":\"027\",\"zone\":\"武汉市\"},{\"code\":\"0710\",\"zone\":\"襄城市\"},{\"code\":\"0711\",\"zone\":\"鄂州市\"},{\"code\":\"0712\",\"zone\":\"孝感市\"},{\"code\":\"0713\",\"zone\":\"黄州市\"},{\"code\":\"0714\",\"zone\":\"黄石市\"},{\"code\":\"0715\",\"zone\":\"咸宁市\"},{\"code\":\"0716\",\"zone\":\"荆沙市\"},{\"code\":\"0717\",\"zone\":\"宜昌市\"},{\"code\":\"0718\",\"zone\":\"恩施市\"},{\"code\":\"0719\",\"zone\":\"十堰市\"},{\"code\":\"0722\",\"zone\":\"随枣市\"},{\"code\":\"0724\",\"zone\":\"荆门市\"},{\"code\":\"0728\",\"zone\":\"江汉市\"},{\"code\":\"025\",\"zone\":\"南京市\"},{\"code\":\"0510\",\"zone\":\"无锡市\"},{\"code\":\"0511\",\"zone\":\"镇江市\"},{\"code\":\"0512\",\"zone\":\"苏州市\"},{\"code\":\"0513\",\"zone\":\"南通市\"},{\"code\":\"0514\",\"zone\":\"扬州市\"},{\"code\":\"0515\",\"zone\":\"盐城市\"},{\"code\":\"0516\",\"zone\":\"徐州市\"},{\"code\":\"0517\",\"zone\":\"淮阴市\"},{\"code\":\"0517\",\"zone\":\"淮安市\"},{\"code\":\"0518\",\"zone\":\"连云港\"},{\"code\":\"0519\",\"zone\":\"常州市\"},{\"code\":\"0523\",\"zone\":\"泰州市\"},{\"code\":\"0470\",\"zone\":\"海拉尔\"},{\"code\":\"0471\",\"zone\":\"呼和浩特\"},{\"code\":\"0472\",\"zone\":\"包头市\"},{\"code\":\"0473\",\"zone\":\"乌海市\"},{\"code\":\"0474\",\"zone\":\"集宁市\"},{\"code\":\"0475\",\"zone\":\"通辽市\"},{\"code\":\"0476\",\"zone\":\"赤峰市\"},{\"code\":\"0477\",\"zone\":\"东胜市\"},{\"code\":\"0478\",\"zone\":\"临河市\"},{\"code\":\"0479\",\"zone\":\"锡林浩特\"},{\"code\":\"0482\",\"zone\":\"乌兰浩特\"},{\"code\":\"0483\",\"zone\":\"阿拉善左旗\"},{\"code\":\"0790\",\"zone\":\"新余市\"},{\"code\":\"0791\",\"zone\":\"南昌市\"},{\"code\":\"0792\",\"zone\":\"九江市\"},{\"code\":\"0793\",\"zone\":\"上饶市\"},{\"code\":\"0794\",\"zone\":\"临川市\"},{\"code\":\"0795\",\"zone\":\"宜春市\"},{\"code\":\"0796\",\"zone\":\"吉安市\"},{\"code\":\"0797\",\"zone\":\"赣州市\"},{\"code\":\"0798\",\"zone\":\"景德镇\"},{\"code\":\"0799\",\"zone\":\"萍乡市\"},{\"code\":\"0701\",\"zone\":\"鹰潭市\"},{\"code\":\"0350\",\"zone\":\"忻州市\"},{\"code\":\"0351\",\"zone\":\"太原市\"},{\"code\":\"0352\",\"zone\":\"大同市\"},{\"code\":\"0353\",\"zone\":\"阳泉市\"},{\"code\":\"0354\",\"zone\":\"榆次市\"},{\"code\":\"0355\",\"zone\":\"长治市\"},{\"code\":\"0356\",\"zone\":\"晋城市\"},{\"code\":\"0357\",\"zone\":\"临汾市\"},{\"code\":\"0358\",\"zone\":\"离石市\"},{\"code\":\"0359\",\"zone\":\"运城市\"},{\"code\":\"0930\",\"zone\":\"临夏市\"},{\"code\":\"0931\",\"zone\":\"兰州市\"},{\"code\":\"0932\",\"zone\":\"定西市\"},{\"code\":\"0933\",\"zone\":\"平凉市\"},{\"code\":\"0934\",\"zone\":\"西峰市\"},{\"code\":\"0935\",\"zone\":\"武威市\"},{\"code\":\"0936\",\"zone\":\"张掖市\"},{\"code\":\"0937\",\"zone\":\"酒泉市\"},{\"code\":\"0938\",\"zone\":\"天水市\"},{\"code\":\"0941\",\"zone\":\"甘南州\"},{\"code\":\"0943\",\"zone\":\"白银市\"},{\"code\":\"0530\",\"zone\":\"菏泽市\"},{\"code\":\"0531\",\"zone\":\"济南市\"},{\"code\":\"0532\",\"zone\":\"青岛市\"},{\"code\":\"0533\",\"zone\":\"淄博市\"},{\"code\":\"0534\",\"zone\":\"德州市\"},{\"code\":\"0535\",\"zone\":\"烟台市\"},{\"code\":\"0536\",\"zone\":\"淮坊市\"},{\"code\":\"0537\",\"zone\":\"济宁市\"},{\"code\":\"0538\",\"zone\":\"泰安市\"},{\"code\":\"0539\",\"zone\":\"临沂市\"},{\"code\":\"0450\",\"zone\":\"阿城市\"},{\"code\":\"0451\",\"zone\":\"哈尔滨\"},{\"code\":\"0452\",\"zone\":\"齐齐哈尔\"},{\"code\":\"0453\",\"zone\":\"牡丹江\"},{\"code\":\"0454\",\"zone\":\"佳木斯\"},{\"code\":\"0455\",\"zone\":\"绥化市\"},{\"code\":\"0456\",\"zone\":\"黑河市\"},{\"code\":\"0457\",\"zone\":\"加格达奇\"},{\"code\":\"0458\",\"zone\":\"伊春市\"},{\"code\":\"0459\",\"zone\":\"大庆市\"},{\"code\":\"0591\",\"zone\":\"福州市\"},{\"code\":\"0592\",\"zone\":\"厦门市\"},{\"code\":\"0593\",\"zone\":\"宁德市\"},{\"code\":\"0594\",\"zone\":\"莆田市\"},{\"code\":\"0595\",\"zone\":\"泉州市\"},{\"code\":\"0595\",\"zone\":\"晋江市\"},{\"code\":\"0596\",\"zone\":\"漳州市\"},{\"code\":\"0597\",\"zone\":\"龙岩市\"},{\"code\":\"0598\",\"zone\":\"三明市\"},{\"code\":\"0599\",\"zone\":\"南平市\"},{\"code\":\"020\",\"zone\":\"广州市\"},{\"code\":\"0751\",\"zone\":\"韶关市\"},{\"code\":\"0752\",\"zone\":\"惠州市\"},{\"code\":\"0753\",\"zone\":\"梅州市\"},{\"code\":\"0754\",\"zone\":\"汕头市\"},{\"code\":\"0755\",\"zone\":\"深圳市\"},{\"code\":\"0756\",\"zone\":\"珠海市\"},{\"code\":\"0757\",\"zone\":\"佛山市\"},{\"code\":\"0758\",\"zone\":\"肇庆市\"},{\"code\":\"0759\",\"zone\":\"湛江市\"},{\"code\":\"0760\",\"zone\":\"中山市\"},{\"code\":\"0762\",\"zone\":\"河源市\"},{\"code\":\"0763\",\"zone\":\"清远市\"},{\"code\":\"0765\",\"zone\":\"顺德市\"},{\"code\":\"0766\",\"zone\":\"云浮市\"},{\"code\":\"0768\",\"zone\":\"潮州市\"},{\"code\":\"0769\",\"zone\":\"东莞市\"},{\"code\":\"0660\",\"zone\":\"汕尾市\"},{\"code\":\"0661\",\"zone\":\"潮阳市\"},{\"code\":\"0662\",\"zone\":\"阳江市\"},{\"code\":\"0663\",\"zone\":\"揭西市\"},{\"code\":\"028\",\"zone\":\"成都市\"},{\"code\":\"0810\",\"zone\":\"涪陵市\"},{\"code\":\"0811\",\"zone\":\"重庆市\"},{\"code\":\"0812\",\"zone\":\"攀枝花\"},{\"code\":\"0813\",\"zone\":\"自贡市\"},{\"code\":\"0814\",\"zone\":\"永川市\"},{\"code\":\"0816\",\"zone\":\"绵阳市\"},{\"code\":\"0817\",\"zone\":\"南充市\"},{\"code\":\"0818\",\"zone\":\"达县市\"},{\"code\":\"0819\",\"zone\":\"万县市\"},{\"code\":\"0825\",\"zone\":\"遂宁市\"},{\"code\":\"0826\",\"zone\":\"广安市\"},{\"code\":\"0827\",\"zone\":\"巴中市\"},{\"code\":\"0830\",\"zone\":\"泸州市\"},{\"code\":\"0831\",\"zone\":\"宜宾市\"},{\"code\":\"0832\",\"zone\":\"内江市\"},{\"code\":\"0833\",\"zone\":\"乐山市\"},{\"code\":\"0834\",\"zone\":\"西昌市\"},{\"code\":\"0835\",\"zone\":\"雅安市\"},{\"code\":\"0836\",\"zone\":\"康定市\"},{\"code\":\"0837\",\"zone\":\"马尔康\"},{\"code\":\"0838\",\"zone\":\"德阳市\"},{\"code\":\"0839\",\"zone\":\"广元市\"},{\"code\":\"0840\",\"zone\":\"泸州市\"},{\"code\":\"0730\",\"zone\":\"岳阳市\"},{\"code\":\"0731\",\"zone\":\"长沙市\"},{\"code\":\"0732\",\"zone\":\"湘潭市\"},{\"code\":\"0733\",\"zone\":\"株州市\"},{\"code\":\"0734\",\"zone\":\"衡阳市\"},{\"code\":\"0735\",\"zone\":\"郴州市\"},{\"code\":\"0736\",\"zone\":\"常德市\"},{\"code\":\"0737\",\"zone\":\"益阳市\"},{\"code\":\"0738\",\"zone\":\"娄底市\"},{\"code\":\"0739\",\"zone\":\"邵阳市\"},{\"code\":\"0743\",\"zone\":\"吉首市\"},{\"code\":\"0744\",\"zone\":\"张家界\"},{\"code\":\"0745\",\"zone\":\"怀化市\"},{\"code\":\"0746\",\"zone\":\"永州冷\"},{\"code\":\"0370\",\"zone\":\"商丘市\"},{\"code\":\"0371\",\"zone\":\"郑州市\"},{\"code\":\"0372\",\"zone\":\"安阳市\"},{\"code\":\"0373\",\"zone\":\"新乡市\"},{\"code\":\"0374\",\"zone\":\"许昌市\"},{\"code\":\"0375\",\"zone\":\"平顶山\"},{\"code\":\"0376\",\"zone\":\"信阳市\"},{\"code\":\"0377\",\"zone\":\"南阳市\"},{\"code\":\"0378\",\"zone\":\"开封市\"},{\"code\":\"0379\",\"zone\":\"洛阳市\"},{\"code\":\"0391\",\"zone\":\"焦作市\"},{\"code\":\"0392\",\"zone\":\"鹤壁市\"},{\"code\":\"0393\",\"zone\":\"濮阳市\"},{\"code\":\"0394\",\"zone\":\"周口市\"},{\"code\":\"0395\",\"zone\":\"漯河市\"},{\"code\":\"0396\",\"zone\":\"驻马店\"},{\"code\":\"0398\",\"zone\":\"三门峡\"},{\"code\":\"0870\",\"zone\":\"昭通市\"},{\"code\":\"0871\",\"zone\":\"昆明市\"},{\"code\":\"0872\",\"zone\":\"大理市\"},{\"code\":\"0873\",\"zone\":\"个旧市\"},{\"code\":\"0874\",\"zone\":\"曲靖市\"},{\"code\":\"0875\",\"zone\":\"保山市\"},{\"code\":\"0876\",\"zone\":\"文山市\"},{\"code\":\"0877\",\"zone\":\"玉溪市\"},{\"code\":\"0878\",\"zone\":\"楚雄市\"},{\"code\":\"0879\",\"zone\":\"思茅市\"},{\"code\":\"0691\",\"zone\":\"景洪市\"},{\"code\":\"0692\",\"zone\":\"潞西市\"},{\"code\":\"0881\",\"zone\":\"东川市\"},{\"code\":\"0883\",\"zone\":\"临沧市\"},{\"code\":\"0886\",\"zone\":\"六库市\"},{\"code\":\"0887\",\"zone\":\"中甸市\"},{\"code\":\"0888\",\"zone\":\"丽江市\"},{\"code\":\"0550\",\"zone\":\"滁州市\"},{\"code\":\"0551\",\"zone\":\"合肥市\"},{\"code\":\"0552\",\"zone\":\"蚌埠市\"},{\"code\":\"0553\",\"zone\":\"芜湖市\"},{\"code\":\"0554\",\"zone\":\"淮南市\"},{\"code\":\"0555\",\"zone\":\"马鞍山\"},{\"code\":\"0556\",\"zone\":\"安庆市\"},{\"code\":\"0557\",\"zone\":\"宿州市\"},{\"code\":\"0558\",\"zone\":\"阜阳市\"},{\"code\":\"0559\",\"zone\":\"黄山市\"},{\"code\":\"0561\",\"zone\":\"淮北市\"},{\"code\":\"0562\",\"zone\":\"铜陵市\"},{\"code\":\"0563\",\"zone\":\"宣城市\"},{\"code\":\"0564\",\"zone\":\"六安市\"},{\"code\":\"0565\",\"zone\":\"巢湖市\"},{\"code\":\"0566\",\"zone\":\"贵池市\"},{\"code\":\"0951\",\"zone\":\"银川市\"},{\"code\":\"0952\",\"zone\":\"石嘴山\"},{\"code\":\"0953\",\"zone\":\"吴忠市\"},{\"code\":\"0954\",\"zone\":\"固原市\"},{\"code\":\"0431\",\"zone\":\"长春市\"},{\"code\":\"0432\",\"zone\":\"吉林市\"},{\"code\":\"0433\",\"zone\":\"延吉市\"},{\"code\":\"0434\",\"zone\":\"四平市\"},{\"code\":\"0435\",\"zone\":\"通化市\"},{\"code\":\"0436\",\"zone\":\"白城市\"},{\"code\":\"0437\",\"zone\":\"辽源市\"},{\"code\":\"0438\",\"zone\":\"松原市\"},{\"code\":\"0439\",\"zone\":\"浑江市\"},{\"code\":\"0440\",\"zone\":\"珲春市\"},{\"code\":\"0770\",\"zone\":\"防城港\"},{\"code\":\"0771\",\"zone\":\"南宁市\"},{\"code\":\"0772\",\"zone\":\"柳州市\"},{\"code\":\"0773\",\"zone\":\"桂林市\"},{\"code\":\"0774\",\"zone\":\"梧州市\"},{\"code\":\"0775\",\"zone\":\"玉林市\"},{\"code\":\"0776\",\"zone\":\"百色市\"},{\"code\":\"0777\",\"zone\":\"钦州市\"},{\"code\":\"0778\",\"zone\":\"河池市\"},{\"code\":\"0779\",\"zone\":\"北海市\"},{\"code\":\"0851\",\"zone\":\"贵阳市\"},{\"code\":\"0852\",\"zone\":\"遵义市\"},{\"code\":\"0853\",\"zone\":\"安顺市\"},{\"code\":\"0854\",\"zone\":\"都均市\"},{\"code\":\"0855\",\"zone\":\"凯里市\"},{\"code\":\"0856\",\"zone\":\"铜仁市\"},{\"code\":\"0857\",\"zone\":\"毕节市\"},{\"code\":\"0858\",\"zone\":\"六盘水\"},{\"code\":\"0859\",\"zone\":\"兴义市\"},{\"code\":\"029\",\"zone\":\"西安市\"},{\"code\":\"0910\",\"zone\":\"咸阳市\"},{\"code\":\"0911\",\"zone\":\"延安市\"},{\"code\":\"0912\",\"zone\":\"榆林市\"},{\"code\":\"0913\",\"zone\":\"渭南市\"},{\"code\":\"0914\",\"zone\":\"商洛市\"},{\"code\":\"0915\",\"zone\":\"安康市\"},{\"code\":\"0916\",\"zone\":\"汉中市\"},{\"code\":\"0917\",\"zone\":\"宝鸡市\"},{\"code\":\"0919\",\"zone\":\"铜川市\"},{\"code\":\"0971\",\"zone\":\"西宁市\"},{\"code\":\"0972\",\"zone\":\"海东市\"},{\"code\":\"0973\",\"zone\":\"同仁市\"},{\"code\":\"0974\",\"zone\":\"共和市\"},{\"code\":\"0975\",\"zone\":\"玛沁市\"},{\"code\":\"0976\",\"zone\":\"玉树市\"},{\"code\":\"0977\",\"zone\":\"德令哈\"},{\"code\":\"0890\",\"zone\":\"儋州市\"},{\"code\":\"0898\",\"zone\":\"海口市\"},{\"code\":\"0899\",\"zone\":\"三亚市\"},{\"code\":\"0891\",\"zone\":\"拉萨市\"},{\"code\":\"0892\",\"zone\":\"日喀则\"},{\"code\":\"0893\",\"zone\":\"山南市\"}]"));
    }
}