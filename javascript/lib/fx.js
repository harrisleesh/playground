function map(f, products) {
    let res = [];
    for (const product of products) {
        res.push(f(product));
    }
    return res;
}

const filter = (f, products) => {
    let res = [];
    for (const p of products) {
        if (f(p)) res.push(p);
    }
    return res;
}

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