//实例化vue对象
new Vue({
    el: "#vue-app", //element
    data() {
        return {
            name: "mister wu",
            wechat: '123456',
            website: 'https://www.baidu.com',
            websiteTag: '<a href="https://www.taobao.com">taobao</a>'
        }
    },
    methods: {
        // greet: function () { //定义一个函数叫greet
        //     return 'Good night ' + this.name;
        // }
        greet(time) {
            // return 'Good night ' + this.name;
            return `Good ${time} ${this.name}`; //反引号是1旁边的符号，ES6的语法
        },

        havelunch() {
            return `吃过午饭了吗？`;
        }

    },
})