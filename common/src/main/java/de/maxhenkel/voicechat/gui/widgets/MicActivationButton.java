package de.maxhenkel.voicechat.gui.widgets;

import de.maxhenkel.voicechat.VoicechatClient;
import de.maxhenkel.voicechat.voice.client.MicrophoneActivationType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class MicActivationButton extends EnumButton<MicrophoneActivationType> {

    private final VoiceActivationSlider voiceActivationSlider;

    public MicActivationButton(int xIn, int yIn, int widthIn, int heightIn, VoiceActivationSlider voiceActivationSlider) {
        super(xIn, yIn, widthIn, heightIn, VoicechatClient.CLIENT_CONFIG.microphoneActivationType);
        this.voiceActivationSlider = voiceActivationSlider;
        updateText();
        setVisibility();
    }

    @Override
    protected ITextComponent getText(MicrophoneActivationType type) {
        return new TranslationTextComponent("message.voicechat.activation_type", type.getText());
    }

    @Override
    protected void onUpdate(MicrophoneActivationType type) {
        setVisibility();
    }

    private void setVisibility() {
        voiceActivationSlider.visible = MicrophoneActivationType.VOICE.equals(entry.get());
    }

}
