const curry = f => (a, ..._) => _.length ? f(a, ..._) : (..._) => f(a, ..._);
const map = curry((f, products) => {
    let res = [];
    for (const product of products) {
        res.push(f(product));
    }
    return res;
});

const filter = curry((f, products) => {
    let res = [];
    for (const p of products) {
        if (f(p)) res.push(p);
    }
    return res;
});

const reduce = curry((f, acc, iter) => {
    if (!iter) {
        iter = acc[Symbol.iterator]();
        acc = iter.next().value;
    }
    for (const a of iter) {
        acc = f(acc, a);
    }
    return acc;
});


const go = (...args) => reduce((a, f) => f(a), args);
const pipe = (f, ...fs) => (...as) => go(f(...as), ...fs);
