<template>
  <div class="body">
    <div class="top pt-1">주문완료!</div>
    <div class="time">
      <p>주문 번호: <span style="font-size: 20px">129번</span></p>
      <p><span style="font-size: 20px">10~15분 </span>정도 소요될 예정이에요.</p>
    </div>
    <div class="store pt-1">서브웨이 {{ basket[0].store.branchName }}점</div>
    <div class="orderCheck pt-3 pb-3">
      <div class="pb-2">주문내역</div>
      <order-detail :bas="bas" v-for="(bas, index) in basket" :key="index"></order-detail>
    </div>
    <div class="checkStore">
      <div>예상 시간에 맞춰 매장에 방문해주세요!</div>
      <div align="center" class="order_btn pb-1">
        <v-btn
          class="main_btn"
          style="font-size: 14px"
          width="185"
          small
          elevation="0"
          rounded
          @click.prevent="goStoreInfo"
          >픽업 매장 확인하기</v-btn
        >
      </div>
    </div>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import OrderDetail from "../../components/common/OrderDetail.vue";
import BottomNav from "@/components/common/BottomNav.vue";
import { mapGetters } from "vuex";
import axios from "axios";
import api from "@/api/api";
export default {
  components: { OrderDetail, BottomNav },
  name: "OrderCheckView",

  props: {
    orderId: Number,
  },

  computed: {
    ...mapGetters(["basket"]),
  },

  methods: {
    goStoreInfo() {
      this.$router.push({ name: "storeinfo" });
    },
  },

  mounted() {
    axios({
      url: api.order.order.readorder(this.orderId),
      method: "get",
    })
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log("orderread 오류", err);
      });
  },
};
</script>

<style scoped>
.body {
  padding-top: 70px;
}
.top {
  position: fixed;
  top: 0;
  height: 55px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #239347;
  color: #f4c41f;
  font-size: 20px;
  font-weight: bold;
}

.time {
  height: 130px;
  width: 100%;
  margin-top: -16px;
  border: 1px solid; /* 나중에 지울 거 */
  display: flex;
  flex-direction: column;
  text-align: center;
  justify-content: center;
}
p {
  font-size: 15px;
}
span {
  font-size: 30px;
  color: #239347;
}
.store {
  height: 50px;
  width: 100%;
  background-color: #f5f5f5;
  display: flex;
  justify-content: center;
  align-items: center;
  margin-bottom: 2px;
}
.orderCheck {
  width: 100%;
  height: 400px;
  overflow: scroll;
  background-color: #f5f5f5;
  text-align: center;
}
.checkStore {
  margin-top: 20px;
  height: 70px;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  align-items: center;
}
</style>
