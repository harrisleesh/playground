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
