import { OrderDataModel } from './OrderData';
export class OrderModel {
    constructor(private pId?: string, private customer?: string, private orderDataDto?: Array<OrderDataModel>
        , private tamount?: string, private tdiscount?: string) { }

    public get PID(): string {
        return this.pId;
    }
    public set PId(value: string) {
        this.pId = value;
    }
    public get Customer(): string {
        return this.customer;
    }
    public set Customer(value: string) {
        this.customer = value;
    }

    public get Tamount(): string {
        return this.tamount;
    }
    public set Tamount(value: string) {
        this.tamount = value;
    }

    public get Tdiscount(): string {
        return this.tdiscount;
    }
    public set Tdiscount(value: string) {
        this.tdiscount = value;
    }

    public get OrderDataDto() {
        return this.orderDataDto;
    }
    public set OrderDataDto(orderDataDto: Array<OrderDataModel>) {
        this.orderDataDto = orderDataDto;
    }

}