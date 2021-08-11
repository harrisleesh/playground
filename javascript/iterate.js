'use strict'

const log = console.log;
log("hello iterable iterator protocol")

const iterable = {
    [Symbol.iterator]() {
        let i = 3;
        return {
            next() {
                return i === 0 ? {done: true} : {value: i--, done: false};
            },
            [Symbol.iterator]() { return this;}
        }
    }
};

let iterator = iterable[Symbol.iterator]();
log(iterator.next());
for (const iteratorElement of iterator) {
    log(iteratorElement);
}

// well formed Iterator?
const arr = [1, 2, 3];
let iter = arr[Symbol.iterator]();
iter.next();
log(iter[Symbol.iterator]() === iter);
for (const number of iter) {
    log(number);
}

log(document.querySelectorAll('*'));
for (const a of document.querySelectorAll('*')) {
    log(a);
}
const all = document.querySelectorAll('*');
const iter2 = all[Symbol.iterator]();
log(iter2.next());
log(iter2.next());
log(iter2.next());


// 전개 연산자
console.clear();
const a = [1, 2];
// a[Symbol.iterator] = null;
log([...a, ...[3,4]]);
log([a, [3,4]]);
