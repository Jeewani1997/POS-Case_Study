import { ItemModel } from './Item';
export class OrderDataModel {
    constructor(private pId?: string, private qtity?: string, private uPrice?: string, private item?: ItemModel, private stotal?: string, private fqtity?: string
        , private itemName?: string, private discount?: string, private ttotal?: string) { }

    public get PId(): string {
        return this.pId;
    }
    public set PId(value: string) {
        this.pId = value;
    }
    public get Qtity(): string {
        return this.qtity;
    }
    public set Qtity(value: string) {
        this.qtity = value;
    }

    public get UPrice(): string {
        return this.uPrice;
    }
    public set UPrice(value: string) {
        this.uPrice = value;
    }

    public get Stotal(): string {
        return this.stotal;
    }
    public set Stotal(value: string) {
        this.stotal = value;
    }

    public get Ttotal(): string {
        return this.ttotal;
    }
    public set Ttotal(value: string) {
        this.ttotal = value;
    }

    public get Item() {
        return this.item;
    }
    public set Item(item: ItemModel) {
        this.item = item;
    }

    public get ItemName() {
        return this.itemName;
    }
    public set ItemName(value: string) {
        this.itemName = value;
    }

    public get Fqtity(): string {
        return this.fqtity;
    }
    public set Fqtity(value: string) {
        this.fqtity = value;
    }
    public get Discount(): string {
        return this.discount;
    }
    public set Discount(value: string) {
        this.discount = value;
    }
}