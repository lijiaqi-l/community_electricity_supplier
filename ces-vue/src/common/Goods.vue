<template>
  <div>
    <el-form :inline="true" :model="form" class="demo-form-inline">
      <el-form-item label="商品名称">
        <el-input v-model="form.name" placeholder="商品名称"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="getRequest()" icon="el-icon-search">查询</el-button>
      </el-form-item>
      <el-form-item>
        <el-button type="success" @click="exportData" icon="el-icon-download">导出数据</el-button>
      </el-form-item>
      <el-form-item>
        <el-upload
          :show-file-list="false"
          :before-upload="beforeUpload"
          :on-success="onSuccess"
          :on-error="onError"
          :disabled="importDataDisabled"
          style="display: inline-flex;margin-right: 8px"
          :action="action"
        >
          <el-button
            :disabled="importDataDisabled"
            type="success"
            :icon="importDataBtnIcon"
          >{{importDataBtnText}}</el-button>
        </el-upload>
      </el-form-item>
    </el-form>
    <el-table :data="tableData" border style="width: 100%">
      <el-table-column fixed prop="id" label="id" width="200"></el-table-column>
      <el-table-column prop="name" label="商品名称" width="200"></el-table-column>
      <el-table-column prop="code" label="商品代码" width="200"></el-table-column>
      <el-table-column prop="inventoryQuantity" label="库存" width="200"></el-table-column>
      <el-table-column prop="model" label="商品样式" width="200"></el-table-column>
      <el-table-column prop="producer" label="生产商" width="300"></el-table-column>
      <el-table-column prop="purchasingPrice" label="采购价格" width="300"></el-table-column>
      <el-table-column prop="sellingPrice" label="销售价格" width="200"></el-table-column>
      <el-table-column prop="lastPurchasingPrice" label="最后成交价" width="200"></el-table-column>
      <el-table-column prop="unit" label="单位" width="200"></el-table-column>
      <el-table-column prop="stateStr" label="状态" width="200"></el-table-column>
    </el-table>

    <el-pagination
      @size-change="handleSizeChange"
      @current-change="handleCurrentChange"
      :current-page="pageNo"
      :page-sizes="[15, 25, 35, 45]"
      :page-size="pageSize"
      layout="total, sizes, prev, pager, next, jumper"
      :total="total"
    ></el-pagination>
  </div>
</template>
<script>
export default {
  mounted() {
    this.getRequest();
    this.action="http://www.jxccloud.com/biz/tGoods/upLoadExcel?access_token="+localStorage.getItem("access_token");
  },
  methods: {
    onSuccess(response, file, fileList) {
        console.log("导入成功:{}",response)
        this.importDataBtnText = "导入数据";
        this.importDataBtnIcon = "el-icon-upload2";
        this.importDataDisabled =false;
        this.getRequest();

    },
    onError(response, file, fileList) {
        console.log("error----------------->:{}",response);
        alert(response.message);
        this.importDataBtnText = "导入数据";
         this.importDataBtnIcon = "el-icon-upload2";
         this.importDataDisabled =false;

    },
    beforeUpload(response, file, fileList) {
      this.importDataBtnText = "正在导入";
      this.importDataBtnIcon = "el-icon-loading";
      this.importDataDisabled = true;
            
    },
    exportData() {
      var url =
        "http://www.jxccloud.com/biz/tGoods/downLoadGoodsExcel?pageNo={pageNo}&pageSize={pageSize}&access_token={token}";
      url = url.replace("{pageNo}", this.form.pageNo);
      url = url.replace("{pageSize}", this.form.pageSize);
      url = url.replace("{token}", localStorage.getItem("access_token"));
      if (this.form.name) {
        url = url + "&name=" + this.form.name;
      }
      console.log("url:----------------------", url);
      window.open(url, "_parent");
    },
    getRequest() {
      this.form.pageNo = this.pageNo;
      this.form.pageSize = this.pageSize;
      var $this = this;
      this.form["access_token"] = localStorage.getItem("access_token");
      this.axios({
        method: "get",
        url: "http://www.jxccloud.com/biz/tGoods/getGoodsPage",
        params: this.form
      }).then(function(res) {
        console.log("==================================", res);
        $this.tableData = res.data.obj.list;
        $this.total = res.data.obj.total;
      });
    },
    handleSizeChange(val) {
      console.log(`每页 ${val} 条`);
      this.pageSize = val;
      this.getRequest();
    },
    handleCurrentChange(val) {
      console.log(`当前页: ${val}`);
      this.pageNo = val;
      this.getRequest();
    }
  },

  data() {
    return {
      tableData: [],
      pageNo: 1,
      pageSize: 10,
      total: 0,
      form: {
        name: "",
        pageNo: 1,
        pageSize: 10
      },
      importDataDisabled: false,
      importDataBtnText: "导入数据",
      importDataBtnIcon: "el-icon-upload2",
      action:""
    };
  }
};
</script>