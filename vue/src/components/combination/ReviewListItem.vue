<template>
  <div>
    <v-container>
      <v-row align="center">
        <v-col cols="1">
          <v-avatar size="45" color="#d9d9d9" @click="goProfile(combiReviewItem.userName)"
            ><img :src="combiReviewItem.profileImg"
          /></v-avatar>
        </v-col>
        <v-col class="ml-5" cols="8">
          <div style="font-size: 13px" @click="goProfile(combiReviewItem.userName)">
            {{ combiReviewItem.userName }} | {{ createDate }}
          </div>
          <div>
            <v-rating
              v-model="rating"
              color="yellow darken-2"
              background-color="yellow darken-2"
              size="18"
              half-increments
              hover
              readonly
            ></v-rating>
          </div>
        </v-col>
        <v-col class="pa-0 ml-n2 mt-n4" align="center">
          <div v-if="combiReviewItem.userId == profile.userId" style="font-size: 12px">
            <span style="color: red" @click="btnDeleteReview">삭제</span>
          </div>
        </v-col>
      </v-row>
    </v-container>
    <v-card elevation="0" class="mb-5 mr-10 ml-10 mt-2">
      <div style="font-size: 14px">
        {{ combiReviewItem.content }}
      </div>
    </v-card>
    <v-card height="1" width="360" elevation="0" style="background-color: #d9d9d9">&nbsp;</v-card>
  </div>
</template>

<script>
import dayjs from "dayjs";
import { mapActions, mapGetters } from "vuex";

export default {
  name: "ReviewListItem",
  data() {
    return {
      rating: this.combiReviewItem.score,
      createDate: "",
    };
  },
  props: {
    combiReviewItem: Object,
  },
  computed: {
    ...mapGetters(["profile"]),
  },
  created() {
    this.createDate = dayjs(this.combiReviewItem.createdAt).format("YYYY-MM-DD HH:mm");
  },
  methods: {
    ...mapActions(["deleteReview", "fetchProfile"]),
    btnDeleteReview() {
      if (confirm("삭제하시겠습니까?")) {
        this.fetchProfile();
        this.deleteReview({
          postId: this.combiReviewItem.combinationPostId,
          reviewId: this.combiReviewItem.reviewId,
          userId: this.profile.userId,
        });
      }
    },
    goProfile(username) {
      this.$router.push({ name: "mypage", params:{userName:username} }).catch(() => {}  )
    },
  },
};
</script>

<style></style>
