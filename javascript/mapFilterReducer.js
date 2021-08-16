console.log('map filter reducer start');
const log = console.log;
const products = [
    {name: '반팔티', price: 15000},
    {name: '긴팔티', price: 20000},
    {name: '핸드폰케이스', price: 15000},
    {name: '바지', price: 30000},
    {name: '후드티', price: 25000},
]

function map(f, products) {
    let res = [];
    for (const product of products) {
        res.push(f(product));
    }
    return res;
}

log(map(p => p.name, products));
// let names = [];
// for (const product of products) {
//     names.push(product.name);
// }
// log(names);

log(map(p => p.price, products));
// let prices = [];
// for (const product of products) {
//     prices.push(product.price);
// }
// log(prices);

console.clear();

log([1, 2, 3].map(a => a + 1));

log(map(el => el.nodeName, document.querySelectorAll('*')));

function* gen() {
    yield 1;
    yield 2;
    yield 3;
}

log(map((a => a * a), gen()));

let m = new Map();
m.set('a', 10);
m.set('b', 20);

log(new Map(map(([k, v]) => [k, v * 2], m)));


console.clear();

const filter = (f, products) => {
    let res = [];
    for (const p of products) {
        if (f(p)) res.push(p);
    }
    return res;
}
log(...filter(p => p.price < 20000, products));
// let under20000 = [];
// for (const product of products) {
//     if (product.price < 20000) {
//         under20000.push(product);
//     }
// }
// log(...under20000);

log(...filter(p => p.price >= 20000, products));
// let over20000 = [];
// for (const product of products) {
//     if (product.price >= 20000) {
//         over20000.push(product);
//     }
// }
// log(...over20000);

log(filter(n => n % 2, [1, 2, 3, 4, 5, 6]));

console.clear();

const numbers = [1, 2, 3, 4, 5];

let total = 0;
for (const number of numbers) {
    total += number;
}
log(total);

const reduce = (f, acc, iter) => {
    if (!iter) {
        iter = acc[Symbol.iterator]();
        acc = iter.next().value;
    }
    for (const a of iter) {
        acc = f(acc, a);
    }
    return acc;
}
const add = (a, b) => a + b;

log(reduce(add, 0, numbers));
// 15

log(reduce(add, numbers));
log(reduce((total_price, product) => total_price + product.price, 0, products));
console.clear()

const go = (...args) => reduce((a, f) => f(a), args);
const pipe = (f, ...fs) => (...as) => go(f(...as), ...fs);
const curry = f => (a, ..._) => _.length ? f(a, ..._) : (..._) => f(a, ..._);
go(
    0,
    a => a + 1,
    a => a + 10,
    a => a + 100,
    log
)

const f = pipe(
    (a, b) => a + b,
    a => a + 10,
    a => a + 100,
)

log(f(0, 1));
