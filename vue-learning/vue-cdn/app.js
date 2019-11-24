//实例化vue对象
new Vue({
    el: "#vue-app", //element
    data() {
        return {
            age: 18,
            X: 0,
            Y: 0,
        }
    },
    methods: {
        add(inc) {
            this.age += inc;
        },
        subtract(dec) {
            this.age -= dec;
        },
        updateXY(event) {
            //console.log(event); /* event事件对象 */
            this.X = event.offsetX;
            this.Y = event.offsetY;
        }
    },
})