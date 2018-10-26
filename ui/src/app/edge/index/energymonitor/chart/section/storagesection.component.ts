import { Component, OnInit, Input } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { AbstractSection, SvgSquarePosition, SvgSquare, EnergyFlow, SvgEnergyFlow } from './abstractsection.component';
import { interval } from 'rxjs';



@Component({
    selector: '[storagesection]',
    templateUrl: './section.component.html'
})
export class StorageSectionComponent extends AbstractSection implements OnInit {
    socValue: number

    constructor(translate: TranslateService) {
        super('Edge.Index.Energymonitor.Storage', "down", 136, 224, "#009846", translate);
    }



    ngOnInit() {
        interval(1000)
            .subscribe(x => {
            })
    }

    public updateStorageValue(chargeAbsolute: number, dischargeAbsolute: number, valueRatio: number, sumChargeRatio: number, sumDischargeRatio: number, powerRatio: number) {
        powerRatio = powerRatio / 2; // interval from -50 to 50
        this.socValue = valueRatio
        if (chargeAbsolute != null && chargeAbsolute > 0) {
            this.name = this.translate.instant('Edge.Index.Energymonitor.StorageCharge')
            super.updateStorage(chargeAbsolute, valueRatio, sumChargeRatio, powerRatio);
        } else if (dischargeAbsolute != null && dischargeAbsolute > 0) {
            this.name = this.translate.instant('Edge.Index.Energymonitor.StorageDischarge')
            super.updateStorage(dischargeAbsolute, valueRatio, sumDischargeRatio * -1, powerRatio);
        } else {
            this.name = this.translate.instant('Edge.Index.Energymonitor.Storage')
            super.updateValue(0, 0, 0);
        }
        if (valueRatio != null) {
            this.valueText2 = Math.round(valueRatio) + " %";
        } else {
            this.valueText2 = "";
        }
        if (this.square) {
            this.square.image.image = "assets/img/" + this.getImagePath()
        }
    }

    protected getSquarePosition(square: SvgSquare, innerRadius: number): SvgSquarePosition {
        let x = (square.length / 2) * (-1);
        let y = innerRadius - 5 - square.length;
        return new SvgSquarePosition(x, y);
    }

    protected getImagePath(): string {
        if (this.socValue < 20) {
            return "storage_20.png"
        }
        else if (this.socValue < 40) {
            return "storage_40.png"
        }
        else if (this.socValue < 60) {
            return "storage_60.png"
        }
        else if (this.socValue < 86) {
            return "storage_80.png"
        }
        else {
            return "storage_100.png"
        }
    }

    protected getValueText(value: number): string {
        if (value == null || Number.isNaN(value)) {
            return "";
        }

        return this.lastValue.valueAbsolute + " W";
    }

    protected initEnergyFlow(radius: number): EnergyFlow {
        return new EnergyFlow(radius, { x1: "50%", y1: "0%", x2: "50%", y2: "100%" });
    }

    protected getSvgEnergyFlow(ratio: number, r: number, v: number): SvgEnergyFlow {
        let p = {
            topLeft: { x: v * -1, y: v },
            bottomLeft: { x: v * -1, y: r },
            topRight: { x: v, y: v },
            bottomRight: { x: v, y: r },
            middleBottom: { x: 0, y: r - v },
            middleTop: { x: 0, y: 0 }
        }
        if (ratio > 0) {
            // towards bottom
            p.bottomLeft.y = p.bottomLeft.y - v;
            p.middleBottom.y = p.middleBottom.y + v;
            p.bottomRight.y = p.bottomRight.y - v;
        }
        return p;
    }
}