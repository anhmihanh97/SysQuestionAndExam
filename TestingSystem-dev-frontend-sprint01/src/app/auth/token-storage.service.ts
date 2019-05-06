import { Injectable } from '@angular/core';

const TOKEN_KEY = 'AuthToken';
const USERNAME_KEY = 'AuthUsername';
const AUTHORITIES_KEY = 'AuthAuthorities';

@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  private roles: Array<string> = [];
  private userId: Array<string> = [];
  U: string;
  constructor() { }

  signOut() {
    // sessionStorage dùng để lưu trữ trình duyệt
    window.sessionStorage.clear();
  }
  // lưu mã thông báo
  public saveToken(token: string) {
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }
  // lấy mã thông báo
  public getToken(): string {
    return sessionStorage.getItem(TOKEN_KEY);
  }
  // lưu lại username tại trình duyệt
  public saveUsername(username: string) {
    window.sessionStorage.removeItem(USERNAME_KEY);
    window.sessionStorage.setItem(USERNAME_KEY, username);
  }
  // lay Email
  public getUsername(): string {
    if (sessionStorage.getItem(USERNAME_KEY) != null) {
      this.U = sessionStorage.getItem(USERNAME_KEY);
      const Usplitted: any = this.U.split('/', 1);
      // console.log(Usplitted);
      return Usplitted;
    }
  }
  // lay UserId
  public getUserId(): number {
    if (sessionStorage.getItem(USERNAME_KEY) != null) {
      this.U = sessionStorage.getItem(USERNAME_KEY);
      const Usplitted: any = this.U.split('/')[1];
      // console.log(Usplitted);
      return Usplitted;
    }
  }
  // lưu lại chức năng
  public saveAuthorities(authorities: string[]) {
    window.sessionStorage.removeItem(AUTHORITIES_KEY);
    window.sessionStorage.setItem(AUTHORITIES_KEY, JSON.stringify(authorities));
  }
  // lấy ra thông tin chức năng của tài khoản đăng nhập
  public getAuthorities(): string[] {
    this.roles = [];
    if (sessionStorage.getItem(TOKEN_KEY)) {
      JSON.parse(sessionStorage.getItem(AUTHORITIES_KEY)).forEach(authority => {
        this.roles.push(authority.authority);
      });
    }
    return this.roles;
  }
}
