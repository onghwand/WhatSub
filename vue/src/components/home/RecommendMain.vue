<template>
  <div class="maincover">
    <div v-if="!val" style="position: relative">
      <div class="" style="position: absolute; z-index: 2; width: 100%">
        <v-card class="home_cover myclass" height="350" width="95%" elevation="5" outlined>
          <div class="pt-15" align="center">
            <h2 style="font-size: 20px">
              <div class="pb-2">몇 가지 질문을 통해</div>
              <div class="pb-2">
                <span style="font-size: 24px; color: #239347">개인 맞춤</span> 및
                <span style="font-size: 24px; color: #239347">썹BTI 맞춤</span>
              </div>
              샌드위치를 추천 받으세요!
            </h2>
            <div class="pt-10" style="font-size: 14px; font-weight: bold">
              나의 취향에 맞게 샌드위치를 추천 받을 수 있습니다.
            </div>
            <div class="pt-6" style="z-index: 1">
              <v-btn class="green_btn" rounded @click.prevent="goSurvey">설문조사 하러 가기</v-btn>
            </div>
          </div>
        </v-card>
      </div>
      <div class="main_card">
        <div>
          <div align="center" style="font-size: 18px; font-weight: bold">개인 맞춤 추천</div>
          <v-card class="home_card_b myclass" elevation="5" outlined color="#f4c41f">
            <v-row class="pl-5 pt-7" align="center">
              <v-col class="pa-0" cols="4"
                ><v-img height="100" width="120" src="@/assets/sample_sand1.png"></v-img
              ></v-col>
              <v-col cols="7" class="pa-0" align="center">
                <div class="mb-2" style="font-weight: bold">치킨 슬라이스</div>
                <div style="font-size: 12px">
                  닭가슴살로 만든 치킨 슬라이스를<br />
                  담백하게 즐겨보세요.
                </div>
              </v-col>
            </v-row>
          </v-card>
        </div>
      </div>
      <div class="main_card">
        <div>
          <div align="center" style="font-size: 18px; font-weight: bold">썹BTI 맞춤 추천</div>
          <v-card class="home_card_b myclass" elevation="5" outlined color="#239347">
            <v-row class="pl-5 pt-7" align="center">
              <v-col class="pa-0" cols="4"
                ><v-img height="100" width="135" src="@/assets/sample_sand2.png"></v-img
              ></v-col>
              <v-col cols="7" class="pa-0" align="center">
                <div class="mb-2" style="font-weight: bold">스테이크&치즈</div>
                <div style="font-size: 12px">
                  육즙이 풍부한 비프 스테이크의<br />
                  풍미가 입안 한가득.
                </div>
              </v-col>
            </v-row>
          </v-card>
        </div>
      </div>
    </div>
    <div v-if="val">
      <div class="main_card">
        <div class="" align="center" style="font-size: 18px; font-weight: bold">개인 맞춤 추천</div>
        <recommend-personal v-if="isLoad"></recommend-personal>
        <div class="text-center pt-6 pb-4" v-else>
          <v-progress-circular :rotate="360" :size="50" :width="15" :value="value" color="#f4c41f">
          </v-progress-circular>
        </div>
      </div>
      <div class="main_card">
        <recommend-subti></recommend-subti>
      </div>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import RecommendPersonal from "./RecommendPersonal.vue";
import RecommendSubti from "./RecommendSubti.vue";

export default {
  name: "RecommendMain",
  components: { RecommendPersonal, RecommendSubti },
  data() {
    return {
      interval: {},
      value: 0,
    };
  },
  computed: {
    ...mapGetters(["profile", "isLoad"]),
    val() {
      return this.profile.subti === null ? false : true;
    },
  },

  methods: {
    goSurvey() {
      this.$router.push({ name: "surveybasic" });
    },
  },

  mounted() {
    this.interval = setInterval(() => {
      if (this.value === 100) {
        return (this.value = 0);
      }
      this.value += 15;
    }, 500);
  },

  beforeDestroy() {
    clearInterval(this.interval);
  },
};
</script>

<style>
.main_card {
  margin-left: 20px;
  margin-right: 20px;
  margin-bottom: 20px;
}
.myclass.v-sheet.v-card {
  border-color: #424242 !important;
  border-width: 2px;
}
.maincover {
  padding-top: 56px;
}
.home_cover {
  background-color: white;
  opacity: 0.9;
  top: 3;
  margin: auto;
}
.v-progress-circular {
  margin: 1rem;
}
</style>
