import { User } from './User';

export interface Group {

    group_id: number;
    group_name: string;
    createBy: User;
    createDate: Date;
}
