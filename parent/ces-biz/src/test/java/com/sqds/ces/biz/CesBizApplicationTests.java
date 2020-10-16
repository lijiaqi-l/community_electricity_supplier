package com.sqds.ces.biz;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import org.apache.poi.hssf.usermodel.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootTest
class CesBizApplicationTests {

    @Test
    void contextLoads() {
    }
    public static void main(String[] args) {
        // assert (false) : "代码生成属于危险操作，请确定配置后取消断言执行代码生成！";
        AutoGenerator mpg = new AutoGenerator();
        // 选择 freemarker 引擎，默认 Velocity
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setAuthor("李嘉琪");
        gc.setOutputDir("D:\\MyCode\\practicaltraining\\community_electricity_supplier\\parent\\ces-biz\\src\\main\\java");
        gc.setFileOverride(false);// 是否覆盖同名文件，默认是false
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        /* 自定义文件命名，注意 %s 会自动填充表实体属性！ */
        // gc.setMapperName("%sDao");
        // gc.setXmlName("%sDao");
        // gc.setServiceName("MP%sService");
        // gc.setServiceImplName("%sServiceDiy");
        // gc.setControllerName("%sAction");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert() {
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("xuda666");
        dsc.setUrl("jdbc:mysql://10.39.39.25:3306/dian_shang?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "hr_","menu_" });// 此处可以修改为您的表前缀
        strategy.setDbColumnUnderline(true)//表名字段名使用下划线
                .setNaming(NamingStrategy.underline_to_camel)//下划线到驼峰的命名方式
                //  .setTablePrefix(new String[]{"hr_","menu_"})//表名前缀
                .setEntityLombokModel(true);//使用lombok
       // strategy.setInclude(new String[] { "t_user","t_user_role","t_role","t_role_menu","t_menu"}); // 需要生成的表
// strategy.setExclude(new String[]{"test"}); // 排除生成的表
// 自定义实体父类
// strategy.setSuperEntityClass("com.baomidou.demo.TestEntity");
// 自定义实体，公共字段
// strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
// 自定义 mapper 父类
// strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
// 自定义 service 父类
// strategy.setSuperServiceClass("com.baomidou.demo.TestService");
// 自定义 service 实现类父类
// strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
// 自定义 controller 父类
// strategy.setSuperControllerClass("com.baomidou.demo.TestController");
// 【实体】是否生成字段常量（默认 false）
// public static final String ID = "test_id";
// strategy.setEntityColumnConstant(true);
// 【实体】是否为构建者模型（默认 false）
// public User setName(String name) {this.name = name; return this;}
// strategy.setEntityBuilderModel(true);
        mpg.setStrategy(strategy);

// 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.sqds.ces.biz");
// pc.setModuleName("test");
        mpg.setPackageInfo(pc);

// 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
// InjectionConfig cfg = new InjectionConfig() {
// @Override
// public void initMap() {
// Map<String, Object> map = new HashMap<String, Object>();
// map.put("abc", this.getConfig().getGlobalConfig().getAuthor() +
// "-mp");
// this.setMap(map);
// }
// };
//
// // 自定义 xxList.jsp 生成
// List<FileOutConfig> focList = new ArrayList<>();
// focList.add(new FileOutConfig("/template/list.jsp.vm") {
// @Override
// public String outputFile(TableInfo tableInfo) {
// // 自定义输入文件名称
// return "D://my_" + tableInfo.getEntityName() + ".jsp";
// }
// });
// cfg.setFileOutConfigList(focList);
// mpg.setCfg(cfg);
//
// // 调整 xml 生成目录演示
// focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
// @Override
// public String outputFile(TableInfo tableInfo) {
// return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
// }
// });
// cfg.setFileOutConfigList(focList);
// mpg.setCfg(cfg);
//
// // 关闭默认 xml 生成，调整生成 至 根目录
// TemplateConfig tc = new TemplateConfig();
// tc.setXml(null);
// mpg.setTemplate(tc);

// 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
// 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
// TemplateConfig tc = new TemplateConfig();
// tc.setController("...");
// tc.setEntity("...");
// tc.setMapper("...");
// tc.setXml("...");
// tc.setService("...");
// tc.setServiceImpl("...");
// 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
// mpg.setTemplate(tc);

// 执行生成
        mpg.execute();

// 打印注入设置【可无】
// System.err.println(mpg.getCfg().getMap().get("abc"));

    }


    @Test
    void create() throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 在Excel工作簿中建一工作表，其名为缺省值
        // 如要新建一名为"效益指标"的工作表，其语句为：
       // HSSFSheet sheet = workbook.createSheet("效益指标");
        HSSFSheet sheet = workbook.createSheet();
        // 在索引0的位置创建行（最顶端的行）
        HSSFRow row = sheet.createRow((short)0);
        //在索引0的位置创建单元格（左上端）
        HSSFCell cell = row.createCell((short)0);

        //设置颜色
        HSSFFont hssfFont = workbook.createFont();
        hssfFont.setColor(HSSFFont.COLOR_RED);
        hssfFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFCellStyle cellStyle= workbook.createCellStyle();
        cellStyle.setFont(hssfFont);
        cell.setCellStyle(cellStyle);


// 定义单元格为字符串类型
        cell.setCellType(HSSFCell.CELL_TYPE_STRING);
// 在单元格中输入一些内容
        cell.setCellValue("增加值");
        // 新建一输出文件流
        FileOutputStream fOut = new FileOutputStream(new File("D:/a.xls"));
// 把相应的Excel 工作簿存盘
        workbook.write(fOut);
        fOut.flush();
// 操作结束，关闭文件
        fOut.close();
        System.out.println("文件生成...");
    }

    @Test
    void read(){
        try {
            // 创建对Excel工作簿文件的引用
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File("D://a.xls")));
            // 创建对工作表的引用。
            // 本例是按名引用（让我们假定那张表有着缺省名"Sheet1"）
            HSSFSheet sheet = workbook.getSheet("Sheet0");
            // 也可用getSheetAt(int index)按索引引用，
            // 在Excel文档中，第一张工作表的缺省索引是0，
            // 其语句为：HSSFSheet sheet = workbook.getSheetAt(0);
            // 读取左上端单元
            HSSFRow row = sheet.getRow(0);
            HSSFCell cell = row.getCell((short)0);
            // 输出单元内容，cell.getStringCellValue()就是取所在单元的值
            System.out.println("左上端单元是： " + cell.getStringCellValue());
        } catch (Exception e) {
            System.out.println("已运行xlRead() : " + e);
       }
    }
}
