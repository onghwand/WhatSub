<template>
  <div>
    <div class="top" style="background-color: white">
      <v-row>
        <v-col cols="4">
          <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
        </v-col>
        <v-col class="mt-1 ml-3"><h3>메뉴 선택</h3></v-col>
      </v-row>
    </div>
    <div class="pt-14">
      <menu-list></menu-list>
    </div>
    <div align="center" class="order_btn">
      <v-btn class="main_btn ma-3" width="185" small elevation="0" rounded @click="goNext"
        >주문하기</v-btn
      >
    </div>
  </div>
</template>

<script>
import MenuList from "@/components/order/MenuList.vue";
import { mapGetters, mapActions } from "vuex";
import swal from 'sweetalert';
export default {
  name: "OrderTwoView",

  components: { MenuList },

  computed: {
    ...mapGetters(["selectedMenu"]),
  },

  methods: {
    ...mapActions(["fetchMenus"]),
    goBack() {
      this.$router.push({ name: "orderone" });
    },

    goNext() {
      if (this.selectedMenu === null || this.selectedMenu === undefined) {
        swal("메뉴를 선택해주세요");
      } else {
        this.$router.push({ path: "orderthree" });
      }
    },
  },

  mounted() {
    this.fetchMenus();
  },
};
</script>

<style scoped>
.body {
  width: 100vw;
  padding-top: 36px;
}
.top {
  padding: 10px;
  position: fixed;
  width: 100%;
}

.row {
  width: 100%;
}
.order_btn {
  height: 52px;
  position: fixed;
  width: 100%;
  bottom: 0;
  background-color: white;
}
.select {
  border: 2px solid #239347;
}
</style>
