import { Component, Input } from '@angular/core';
import { AbstractControl, FormArray, FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute, Params } from '@angular/router';

import { Websocket } from '../../../../shared/shared';
import { AbstractConfig, ConfigureRequest, ConfigureUpdateRequest } from '../../abstractconfig';
import { AbstractConfigForm } from '../../abstractconfigform';

@Component({
    selector: 'channelthreshold',
    templateUrl: './channelthreshold.component.html',
})
export class ChannelthresholdComponent extends AbstractConfigForm {

    public schedulerForm: FormGroup;

    constructor(
        public websocket: Websocket,
        private formBuilder: FormBuilder
    ) {
        super(websocket);
    }

    @Input()
    set form(form: FormGroup) {
        this.schedulerForm = form;
    }

    /**
     * useless, need to be here because it's abstract in superclass
     */
    protected getConfigureCreateRequests(form: FormGroup): ConfigureRequest[] {
        return;
    }

    addControllerToThreshold(thresholdForm: FormArray) {
        thresholdForm.push(this.formBuilder.control(""));
        thresholdForm.markAsDirty();
    }

    removeControllerFromThreshold(thresholdForm: FormArray, index: number) {
        thresholdForm.removeAt(index);
        thresholdForm.markAsDirty();
    }

    addThreshold(thresholdForm: FormArray) {
        thresholdForm.push(this.formBuilder.group({
            "threshold": this.formBuilder.control(""),
            "hysteresis": this.formBuilder.control(""),
            "controller": this.formBuilder.array([])
        }))
    }

    removeThreshold(thresholdForm: FormArray, index: number) {
        thresholdForm.removeAt(index);
        thresholdForm.markAsDirty();
    }

    public addControllerToAlways() {
        let controllers = <FormArray>this.schedulerForm.controls["scheduler"]["controls"]["always"];
        controllers.push(
            this.formBuilder.control("")
        );
        controllers.markAsDirty();
    }

    public removeControllerFromAlways(controllerIndex: number) {
        let controllers = <FormArray>this.schedulerForm.controls["scheduler"]["controls"]["always"];
        controllers.removeAt(controllerIndex);
        controllers.markAsDirty();
    }
}