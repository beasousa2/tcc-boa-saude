import { Component, EventEmitter, forwardRef, Input, OnInit, Output } from '@angular/core';
import { ControlValueAccessor, NG_VALUE_ACCESSOR } from '@angular/forms';

const INPUT_FIELD_VALUE_ACCESSOR: any = {
  provide: NG_VALUE_ACCESSOR,
  useExisting: forwardRef(() => SelectComponent),
  multi: true
};

@Component({
  selector: 'app-select',
  templateUrl: './select.component.html',
  styleUrls: ['./select.component.scss'],
  providers: [INPUT_FIELD_VALUE_ACCESSOR]
})
export class SelectComponent implements ControlValueAccessor, OnInit {
  @Input() control: any;
  @Input() options: any;
  @Input() field: string = '';
  @Output() selectedValue = new EventEmitter<string>();

  placeholder = 'Selecione';

  active = false;

  private _value: string = '';

  get value() {
    return this._value;
  }

  set value(value: any) {
    this._value = value;

    this.onChange(this._value);
  }

  onChange: (_: any) => void = () => {};
  onTouched: () => void = () => {};
  onValidationChange: () => void = () => {};

  constructor() {}

  ngOnInit(): void {
    this.active = false;
  }

  writeValue(value: string): void {
    this.value = value ? value : '';
  }

  registerOnChange(fn: any): void {
    this.onChange = fn
  }

  registerOnTouched(fn: any): void {
    this.onTouched = fn;
  }

  registerOnValidatorChange?(fn: () => void): void {
    this.onValidationChange = fn;
  }

  showContent() {
    this.active = true;
  }

  close() {
    this.active = false;
  }

  selectOption(value: string) {
    this.placeholder = value;
    this.selectedValue.emit(value);
    this.active = false;
  }



}
