import axios from 'axios';

const instance = axios.create({
    baseURL: 'http://ec2-52-78-114-159.ap-northeast-2.compute.amazonaws.com/api',
    headers: {
        'Content-Type': 'application/json'
    }
});

export default instance;
