<template>
  <div class="mb-n2">
    <v-card class="sand_big_card">
      <v-row class="">
        <v-col class="pa-0 mt-3 ml-3" cols="5" align="center" @click="goCombiDetail">
          <v-img class="shadow_img" height="72" width="130" :src="combiListItem.imgUrl"></v-img>
          <div class="mt-1">
            <h6 style="font-size: 15px; font-weight: bold">{{ combiListItem.combName }}</h6>
          </div>
          <div>
            <h6 style="font-size: 13px; font-weight: 400">
              {{ combiListItem.combination.price | comma }}원
            </h6>
          </div>
        </v-col>
        <v-col>
          <div class="mt-1 ml-n2" @click="goCombiDetail">
            <h6 style="font-size: 14px; font-weight: 500">
              메뉴: {{ combiListItem.menuName }}<br />추가재료: {{ others[0] }}···<br />소스:
              {{ sauce[0] }}···
            </h6>
          </div>
          <div class="mt-4 ml-n3">
            <v-icon size="20" color="yellow darken-2">mdi-star</v-icon>
            <span style="font-size: small"> {{ combiListItem.scoreAvg }}</span>
            <v-icon class="ml-2" size="17" color="green darken-2">mdi-message-outline</v-icon>
            <span style="font-size: small"> {{ combiListItem.reviewCnt }}</span>
            <v-icon class="ml-2" size="17" color="red">mdi-heart</v-icon>
            <span style="font-size: small"> {{ combiListItem.likesCnt }}</span>
          </div>
        </v-col>
      </v-row>
    </v-card>
  </div>
</template>

<script>
export default {
  name: "CombiListItem",
  props: {
    combiListItem: Object,
  },
  data() {
    return {
      others: [],
      sauce: [],
    };
  },
  filters: {
    comma(val) {
      return String(val).replace(/\B(?=(\d{3})+(?!\d))/g, ",");
    },
  },

  // watch: {
  //   combiListItem () {
  //     for (let index = 0; index < this.combiListItem.ingredients.length; index++) {
  //       if (this.combiListItem.ingredients[index].category == "추가") {
  //         this.others.push(this.combiListItem.ingredients[index].name);
  //       } else if (this.combiListItem.ingredients[index].category == "소스") {
  //         this.sauce.push(this.combiListItem.ingredients[index].name);
  //       }
  //     }
  //   }
  // },
  created() {
    for (let index = 0; index < this.combiListItem.ingredients.length; index++) {
      if (this.combiListItem.ingredients[index].category == "추가") {
        this.others.push(this.combiListItem.ingredients[index].name);
      } else if (this.combiListItem.ingredients[index].category == "소스") {
        this.sauce.push(this.combiListItem.ingredients[index].name);
      }
    }
  },
  methods: {
    goCombiDetail() {
      this.$router.push({
        name: "combinationdetail",
        params: {
          combinationPostId: this.combiListItem.combinationPostId,
        },
      });
    },
  },
};
</script>

<style>
.sand_big_card {
  height: 140px;
  width: 333px;
}
</style>
