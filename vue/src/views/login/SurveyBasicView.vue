<template>
  <div class="body">
    <div class="title"><h4>기본 취향 파악</h4></div>
    <div class="backbar">
      <v-btn @click="goBack" icon><v-icon>mdi-arrow-left</v-icon></v-btn>
      <progress value="1" max="2"></progress>
    </div>
    <div class="vegetable mt-3">
      <h4>못먹거나 싫어하는 음식을 선택해 주세요.</h4>
      <div class="con">
        <!-- <button class="vege"   @click="fetchVege"
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v01.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v02.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v03.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v04.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v05.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v06.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v07.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v08.jpg);
              background-size: 100% 100%;">
        </button>
        <button class="vege" 
        style="background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v09.jpg);
              background-size: 100% 100%;">
        </button> -->
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege1"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v01.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege2"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v02.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege3"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v03.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege4"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v04.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege5"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v05.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege6"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v06.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege7"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v07.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege8"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v08.jpg);
            background-size: 100% 100%;
          "
        />
        <input
          type="checkbox"
          class="vege"
          v-model="vegetable.vege9"
          style="
            background-image: url(https://www.subway.co.kr/images/menu/img_recipe_v09.jpg);
            background-size: 100% 100%;
          "
        />
      </div>
    </div>
    <v-divider class="mt-n5"></v-divider>
    <div class="allergie pt-7">
      <h4 class="pb-2">알레르기 유발하는 음식을 선택해주세요.</h4>
      <div class="allcon">
        <div class="allrow">
          <button class="aller" id="1" @click="changeAll">계란</button>
          <button class="aller" id="2" @click="changeAll">우유</button>
          <button class="aller" id="3" @click="changeAll">대두</button>
          <button class="aller" id="4" @click="changeAll">토마토</button>
        </div>
        <div class="allrow">
          <button class="aller" id="5" @click="changeAll">쇠고기</button>
          <button class="aller" id="6" @click="changeAll">돼지고기</button>
          <button class="aller" id="7" @click="changeAll">닭고기</button>
          <button class="aller" id="8" @click="changeAll">새우</button>
        </div>
        <div class="allrow">
          <button class="aller" id="9" @click="changeAll">조개류</button>
          <button class="aller" id="10" @click="changeAll">아황산</button>
        </div>
      </div>
    </div>
    <v-divider class="mt-8"></v-divider>
    <div class="diet pt-7">
      <h4 class="pb-2">식단 관리 중이라면 체크해주세요.</h4>
      <button class="dietbtn" @click="changeDiet">식단 관리 중</button>
    </div>
    <br />
    <v-btn class="main_btn next_btn" small rounded @click="next">다음</v-btn>
    <div class="bottom">
      <bottom-nav></bottom-nav>
    </div>
  </div>
</template>

<script>
import api from "@/api/api";
import axios from "axios";
import BottomNav from "../../components/common/BottomNav.vue";
import { mapActions, mapGetters } from "vuex";
export default {
  components: { BottomNav },
  name: "SurveyBasicView",

  data() {
    return {
      vegetable: {
        vege1: false,
        vege2: false,
        vege3: false,
        vege4: false,
        vege5: false,
        vege6: false,
        vege7: false,
        vege8: false,
        vege9: false,
      },
      allergie: {
        allergie1: false,
        allergie2: false,
        allergie3: false,
        allergie4: false,
        allergie5: false,
        allergie6: false,
        allergie7: false,
        allergie8: false,
        allergie9: false,
        allergie10: false,
      },

      isDiet: false,
    };
  },

  computed: {
    ...mapGetters(["authHeader", "profile"]),
    vegetables() {
      let veges = [];
      const mapping = {
        vege1: "3a",
        vege2: "3b",
        vege3: "3c",
        vege4: "3d",
        vege5: "3e",
        vege6: "3f",
        vege7: "3g",
        vege8: "3h",
        vege9: "6c",
      };

      for (let key in this.vegetable) {
        if (this.vegetable[key]) {
          veges.push(mapping[key]);
        }
      }
      return veges;
    },

    allergies() {
      let alls = [];
      for (let key in this.allergie) {
        const i = key.slice(8);
        const all = document.getElementById(`${i}`);
        const text = all.innerText;
        console.log(text);
        if (this.allergie[key]) {
          alls.push(`${text}`);
        }
      }
      return alls;
    },
  },

  mounted() {
    this.fetchProfile();
  },

  methods: {
    ...mapActions(["fetchProfile", "authHeader"]),
    goBack() {
      this.$router.go(-1);
    },

    changeDiet(event) {
      this.isDiet = !this.isDiet;
      if (this.isDiet) {
        console.log(this.isDiet);
        console.log(event.target.classList);
        event.target.classList.add("checked");
      } else {
        console.log(this.isDiet);
        console.log(event.target.classList);
        event.target.classList.remove("checked");
      }
    },

    changeAll(event) {
      console.log(this["allergie"]["allergie" + event.target.id]);
      // console.log(event.target.id)
      // console.log(eval("this.allergie" + event.target.id))
      this["allergie"]["allergie" + event.target.id] =
        !this["allergie"]["allergie" + event.target.id];
      if (this["allergie"]["allergie" + event.target.id]) {
        event.target.classList.add("checked");
      } else {
        event.target.classList.remove("checked");
      }
    },

    next() {
      //axios로 체크한거 백으로 요청
      //다음 페이지로 넘기기
      axios({
        url: api.accounts.exclude(this.profile.userName),
        method: "post",
        data: {
          allergies: this.allergies,
          diet: this.isDiet,
          vegetables: this.vegetables,
        },
        headers: this.authHeader,
      })
        .then((res) => {
          console.log(res);
          this.$router.push({ name: "surveysubti" });
        })
        .catch((err) => {
          console.error(err);
        });
    },
  },
};
</script>

<style scoped>
.body {
  padding-bottom: 70px;
  padding-top: 46px;
}
.title {
  height: 50px;
  width: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  position: fixed;
  top: 0;
  background-color: white;
}
.checked {
  border: 3px solid #f4c41f;
}

input[type="checkbox"]:checked {
  background-color: #f4c41f;
  border: 5px solid #f4c41f;
}

.backbar {
  width: 90%;
  margin: auto;
  display: flex;
  align-items: center;
}
progress {
  display: block;
  height: 25px;
  width: 80%;
}
.vegetable {
  width: 90%;
  margin: auto;
  height: 360px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
}

.vege {
  appearance: none;
  height: 80px;
  width: 80px;
  border-radius: 50%;
  border-style: solid;
  border: 2px solid;
}
/* .vege img {
  width: 100%;
  border-radius: 50%;
} */
.con {
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
  display: grid;
  grid-gap: 20px;
  grid-template-rows: 80px 80px 80px;
  grid-template-columns: 80px 80px 80px;
  justify-content: center;
}
.allergie {
  width: 90%;
  margin: auto;
  height: 220px;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-bottom: 20px;
}
.allcon {
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
}
.allrow {
  margin-top: 10px;
  margin-bottom: 10px;
}
.aller {
  border-style: solid;
  width: 70px;
  height: 30px;
  border-radius: 15px;
  margin: 5px;
  font-size: 14px;
}

.diet {
  width: 90%;
  margin: auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.dietbtn {
  border-style: solid;
  width: 100px;
  height: 30px;
  border-radius: 15px;
  margin: auto;
  margin-top: 15px;
  font-size: 14px;
}
.next_btn {
  width: 185px;
  height: 30px;
  display: block;
  margin: auto;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>
