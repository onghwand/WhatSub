<template>
  <div>
    <div align="center" style="font-size: 18px; font-weight: bold">다른 유저의 추천 꿀조합</div>
    <div class="verti_combi no-scroll">
      <div class="combi_card" v-for="(combiListItem, index) in combiListByOthers" :key="index">
        <recommend-comb-list-item :combi-list-item="combiListItem"></recommend-comb-list-item>
      </div>
    </div>
  </div>
</template>

<script>
import RecommendCombListItem from "@/components/home/RecommendCombListItem.vue";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "RecommendCombList",
  components: { RecommendCombListItem },
  props: {
    combiList: Array,
  },
  created() {
    this.getCombiListByOthers();
  },
  computed: {
    ...mapGetters(["combiListByOthers"]),
  },
  methods: {
    ...mapActions(["getCombiListByOthers"]),
  },
};
</script>

<style>
@import "@/scss/common.scss";

.combi_card {
  margin-left: 20px;
  margin-top: 5px;
  margin-bottom: 20px;
}
.combi_card:last-child {
  margin-right: 20px;
}
</style>
