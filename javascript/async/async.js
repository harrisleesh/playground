function fetchUser() {
    return new Promise(((resolve, reject) => {
        return resolve('harris');
    }));
}

async function fetchUserAsync(){
    return 'harris';
}
const user = fetchUserAsync();
user.then(console.log);
console.log(user);