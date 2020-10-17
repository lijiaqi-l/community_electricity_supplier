<template>
  <div>
    <canvas id="q"></canvas>
  </div>
</template>

<script>
export default {
  mounted() {
    var canvas = document.getElementById("q");
    var $this = this;
    this.axios({
      method: "post",
      url: "http://www.jxccloud.com/biz/alibaba/pay/createPayOrder",
      params: {
        access_token: localStorage.getItem("access_token"),
        orderNo: new Date().getTime()
      }
    }).then(function(res) {
        console.log("生成支付宝扫码二维码返回信息为{}",res);
       $this.QRCode.toCanvas(
        canvas,
        res.data.obj,
        function(error) {
          if (error) {
            console.error(error);
          }
          console.log("QRCode success!");
        }
      );
    });
  }
};
</script>