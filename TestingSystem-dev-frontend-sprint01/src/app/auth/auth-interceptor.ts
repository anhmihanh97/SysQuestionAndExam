import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { TokenStorageService } from './token-storage.service';
const TOKEN_HEADER_KEY = 'Authorization';
// định nghĩa các kiểu dữ liệu tự tạo ra
@Injectable()
// HttpInterceptor với intercept()phương thức để kiểm tra và chuyển đổi
// các yêu cầu HTTP (trước khi chúng được gửi đến máy chủ)
export class AuthInterceptor implements HttpInterceptor {

    constructor(private token: TokenStorageService) { }
// object HTTPRequest kiểm tra chuyển tiếp đến handle() phương thức của HttpHandler
// handle() đổi object HTTPRequest thành một Observable trong HttpEvents đó bao gồm phản hồi của máy chủ
// next: HttpHandler đại diện cho tiếp theo interceptortrong chuỗi interceptor . tiếp theo đó do HttpClient xử lý

    intercept(req: HttpRequest<any>, next: HttpHandler) {
        let authReq = req;   // req : yêu cầu
        const token = this.token.getToken();  // mã thông báo
        if (token != null) {
            authReq = req.clone({ headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
        }
        return next.handle(authReq);
    }
}

export const httpInterceptorProviders = [
    { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
];
