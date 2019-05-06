

export class SignUpInfo {
    email: string;
    fullName: string;
    mobile: string;
    password: string;
    status: number;
    role: string[];

    constructor( email: string, fullName: string, mobile: string, password: string, status: number) {
        this.email = email;
        this.fullName = fullName;
        this.mobile = mobile;
        this.password = password;
        this.status = 1;
        this.role = ['user'];
    }
}
