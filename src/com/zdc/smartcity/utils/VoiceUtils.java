package com.zdc.smartcity.utils;

import android.content.Context;
import android.os.Bundle;

import com.iflytek.cloud.InitListener;
import com.iflytek.cloud.SpeechConstant;
import com.iflytek.cloud.SpeechError;
import com.iflytek.cloud.SpeechSynthesizer;
import com.iflytek.cloud.SpeechUtility;
import com.iflytek.cloud.SynthesizerListener;
import com.iflytek.cloud.ui.RecognizerDialog;
import com.iflytek.cloud.ui.RecognizerDialogListener;

/**
 * description:�������񹤾���
 * 
 * @author zhaodecang
 * @date 2016-9-30����9:15:07
 */
public class VoiceUtils {

	private Context mContext;

	public VoiceUtils(Context context) {
		this.mContext = context;

		// ����12345678���滻���������APPID�������ַ��http://open.voicecloud.cn
		SpeechUtility.createUtility(mContext, SpeechConstant.APPID + "=57de9d4d");
	}

	/**
	 * �������������ʶ��
	 */
	public void startUIVoiceListen(RecognizerDialogListener listener) {
		// 1.����SpeechRecognizer���󣬵ڶ���������������дʱ��InitListener
		RecognizerDialog iatDialog = new RecognizerDialog(mContext,
				new MyInitListener());
		// 2.������д������ͬ�Ͻ�
		iatDialog.setParameter(SpeechConstant.DOMAIN, "iat");
		iatDialog.setParameter(SpeechConstant.LANGUAGE, "zh_cn");
		iatDialog.setParameter(SpeechConstant.ACCENT, "mandarin ");
		// 3.���ûص��ӿ�, ������Ҫ����ഫ�ݹ���, ��ʶ��ɹ���, ��Ҫ�ش����Ǹ���
		iatDialog.setListener(listener);
		// 4.��ʼ��д
		iatDialog.show();
	}

	/**
	 * �Ѹ������ַ���, ���ų���
	 * 
	 * @param text
	 */
	public void speakText(String text) {
		// 1.����SpeechSynthesizer����, �ڶ������������غϳ�ʱ��InitListener
		SpeechSynthesizer mTts = SpeechSynthesizer.createSynthesizer(mContext, null);
		// 2.�ϳɲ������ã�������ƴ�Ѷ��MSC API�ֲ�(Android)��SpeechSynthesizer ��
		mTts.setParameter(SpeechConstant.VOICE_NAME, "xiaoyan");// ���÷�����
		mTts.setParameter(SpeechConstant.SPEED, "50");// ��������
		mTts.setParameter(SpeechConstant.VOLUME, "80");// ������������Χ0~100
		// ���úϳ���Ƶ����λ�ã����Զ��屣��λ�ã��������ڡ�./sdcard/iflytek.pcm��
		// ������SD����Ҫ��AndroidManifest.xml���дSD��Ȩ��
		// �������Ҫ����ϳ���Ƶ��ע�͸��д���
		// mTts.setParameter(SpeechConstant.TTS_AUDIO_PATH,
		// "./sdcard/iflytek.pcm");
		// 3.��ʼ�ϳ�
		mTts.startSpeaking(text, new MySynthesizerListener());
	}

	class MySynthesizerListener implements SynthesizerListener {

		@Override
		public void onBufferProgress(int arg0, int arg1, int arg2, String arg3) {

		}

		@Override
		public void onCompleted(SpeechError arg0) {

		}

		@Override
		public void onEvent(int arg0, int arg1, int arg2, Bundle arg3) {

		}

		@Override
		public void onSpeakBegin() {

		}

		@Override
		public void onSpeakPaused() {

		}

		@Override
		public void onSpeakProgress(int arg0, int arg1, int arg2) {

		}

		@Override
		public void onSpeakResumed() {

		}
	}

	class MyInitListener implements InitListener {
		@Override
		public void onInit(int arg0) {

		}
	}
}
